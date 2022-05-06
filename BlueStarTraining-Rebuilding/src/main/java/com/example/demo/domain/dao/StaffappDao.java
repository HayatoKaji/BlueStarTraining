package com.example.demo.domain.dao;

import java.util.List;

import com.example.demo.domain.model.User;

public interface StaffappDao {
	public void newStaff(User user);

	public List<User> findDepart(String staffDepartment);

	public List<User> findAll();

	public User findById(String staffCode);

	public void updateStaff(String beforeStaffCode, User user);

	public void deleteStaff(String staffCode, User user);
}
