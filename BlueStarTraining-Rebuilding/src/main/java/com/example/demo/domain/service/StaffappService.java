package com.example.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.dao.StaffappDao;
import com.example.demo.domain.model.User;

@Service
public class StaffappService {

	@Autowired
	StaffappDao dao;

	public void newStaff(User user) {
		dao.newStaff(user);
	}

	public List<User> findDepart(String staffDepartment) {
		return dao.findDepart(staffDepartment);
	}

	public List<User> findAll() {
		return dao.findAll();
	}

	public User findById(String staffCode) {
		return dao.findById(staffCode);
	}

	public void updateStaff(String beforeStaffCode, User user) {
		dao.updateStaff(beforeStaffCode, user);
	}

	public void deleteStaff(String staffCode, User user) {
		dao.deleteStaff(staffCode, user);
	}

}
