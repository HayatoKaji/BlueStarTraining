package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.dao.TrainingDao;
import com.example.demo.domain.model.User;

@Service
public class TrainingService {

	@Autowired
	TrainingDao dao;

	public void newStaff(User user) {
		dao.newStaff(user);
	}

}
