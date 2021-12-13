package com.example.demo.domain.dao.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.dao.TrainingDao;
import com.example.demo.domain.model.User;

@Repository
public class TrainingDaoimpl implements TrainingDao {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public void newStaff(User user) {
		String sql = "INSERT INTO staffs(staff_code,last_name,first_name,last_name_romaji,first_name_romaji,staff_department,project_type,joined_year,new_glad_flg,created_by,updated_by,created_at,updated_at) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbc.update(sql, user.getStaff_code(), user.getLast_name(), user.getFirst_name(), user.getLast_name_romaji(),
				user.getFirst_name_romaji(), user.getStaff_department(), user.getProject_type(), user.getJoined_year(),
				user.getNew_glad_flg(), user.getCreated_by(), user.getUpdated_by(), user.getCreated_at(),
				user.getUpdated_at());
	}

}
