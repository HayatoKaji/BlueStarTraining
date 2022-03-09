package com.example.demo.domain.dao.daoimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.dao.StaffappDao;
import com.example.demo.domain.model.User;

@Repository
public class StaffappDaoimpl implements StaffappDao {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public void newStaff(User user) {
		long millis = System.currentTimeMillis();
		Timestamp nowTime = new Timestamp(millis);
		String sql = "INSERT INTO staffs"
				+ "(id, staff_code,last_name,first_name,last_name_romaji,first_name_romaji,staff_department,"
				+ "project_type,joined_year,new_glad_flg,created_by,updated_by,created_at,updated_at)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbc.update(sql, user.getId(), user.getStaffCode(), user.getLastName(), user.getFirstName(),
				user.getLastNameRomaji(), user.getFirstNameRomaji(), user.getStaffDepartment(), user.getProjectType(),
				user.getJoinedYear(), user.getNewGladFlg(), "user", "user", nowTime, nowTime);
	}

	public List<User> findAll() { // url(https://zenn.dev/waka_morita/articles/ed441b3e5b0b76#%E3%80%90queryforlist%E3%80%91)を参照
		String sql = "SELECT * FROM staffs"; // sqlを全て選択
		List<Map<String, Object>> users = jdbc.queryForList(sql); // mapを利用しl43をusersに代入
		List<User> list = new ArrayList<User>(); // listを作成
		for (Map<String, Object> entry : users) {
			User user = new User();
			user.setId((long) entry.get("id"));
			user.setStaffCode((String) entry.get("staff_code"));
			user.setLastName((String) entry.get("last_name"));
			user.setFirstName((String) entry.get("first_name"));
			user.setLastNameRomaji((String) entry.get("last_name_romaji"));
			user.setFirstNameRomaji((String) entry.get("first_name_romaji"));
			user.setJoinedYear((String) entry.get("joined_year"));
			list.add(user);

		}
		return list;
	}

	public List<User> findDepart(String staffDepartment) { // url(https://zenn.dev/waka_morita/articles/ed441b3e5b0b76#%E3%80%90queryforlist%E3%80%91)を参照
		String sql = "SELECT * FROM staffs WHERE staff_department=?"; // sqlから営業を選択
		List<Map<String, Object>> users = jdbc.queryForList(sql, staffDepartment); // mapを利用しl43をusersに代入
		List<User> list = new ArrayList<User>(); // listを作成
		for (Map<String, Object> entry : users) {
			User user = new User();
			user.setId((long) entry.get("id"));
			user.setLastName((String) entry.get("last_name"));
			user.setFirstName((String) entry.get("first_name"));
			user.setJoinedYear((String) entry.get("joined_year"));
			user.setNewGladFlg((Integer) entry.get("new_glad_flg"));
			user.setProjectType((String) entry.get("project_type"));
			list.add(user);
		}
		return list;
	}

	public User findById(String staffCode) {
		Map<String, Object> users = jdbc.queryForMap("SELECT * FROM staffs WHERE staff_code = ?", staffCode);// mapを利用しcodeを元にデータを抽出
		User user = new User();
		user.setId((long) users.get("id"));
		user.setStaffCode((String) users.get("staff_code"));
		user.setLastName((String) users.get("last_name"));
		user.setFirstName((String) users.get("first_name"));
		user.setLastNameRomaji((String) users.get("last_name_romaji"));
		user.setFirstNameRomaji((String) users.get("first_name_romaji"));
		user.setStaffDepartment((String) users.get("staff_department"));
		user.setJoinedYear((String) users.get("joined_year"));
		user.setNewGladFlg((Integer) users.get("new_glad_flg"));
		user.setProjectType((String) users.get("project_type"));
		return user;
	}

	public void updateStaff(String beforeStaffCode, User user) {
		long millis = System.currentTimeMillis();
		Timestamp nowTime = new Timestamp(millis);
		String sql = "UPDATE staffs SET staff_code = ?, last_name = ?, first_name = ?, last_name_romaji = ?,"
				+ "first_name_romaji = ?, staff_department = ?, project_type = ?, joined_year = ?,"
				+ "new_glad_flg = ?, updated_by = ?, updated_at = ? WHERE staff_code = ?";
		jdbc.update(sql, user.getStaffCode(), user.getLastName(), user.getFirstName(), user.getLastNameRomaji(),
				user.getFirstNameRomaji(), user.getStaffDepartment(), user.getProjectType(), user.getJoinedYear(),
				user.getNewGladFlg(), "user", nowTime, beforeStaffCode);
	}

	public interface DiaryRepository extends CrudRepository<User, Integer> {
	}
	// CRUDリポジトリー？別の方法を聞く

	public void deleteStaff(String staffCode, User user) {
		String sql = "DELETE from staffs WHERE staff_code = ?";
		jdbc.update(sql, staffCode);
	}
}
