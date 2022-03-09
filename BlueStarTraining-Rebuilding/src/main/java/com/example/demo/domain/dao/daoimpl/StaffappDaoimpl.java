package com.example.demo.domain.dao.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
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
		String sql = "INSERT INTO staffs(staff_code,last_name,first_name,last_name_romaji,first_name_romaji,staff_department,project_type,joined_year,new_glad_flg,created_by,updated_by,created_at,updated_at) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbc.update(sql, user.getstaffCode(), user.getlastName(), user.getfirstName(), user.getlastNameRomaji(),
				user.getfirstNameRomaji(), user.getstaffDepartment(), user.getprojectType(), user.getjoinedYear(),
				user.getnewGladFlg());

	}

}
