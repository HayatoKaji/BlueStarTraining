package com.example.demo.domain.service;

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

}
