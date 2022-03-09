package com.example.demo.domain.model;

public class User {

	private long id;
	private String staffCode;
	private String lastName;
	private String firstName;
	private String lastNameRomaji;
	private String firstNameRomaji;
	private String staffDepartment;
	private String projectType;
	private String joinedYear;
	private Integer newGladFlg;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNameRomaji() {
		return lastNameRomaji;
	}

	public void setLastNameRomaji(String lastNameRomaji) {
		this.lastNameRomaji = lastNameRomaji;
	}

	public String getFirstNameRomaji() {
		return firstNameRomaji;
	}

	public void setFirstNameRomaji(String firstNameRomaji) {
		this.firstNameRomaji = firstNameRomaji;
	}

	public String getStaffDepartment() {
		return staffDepartment;
	}

	public void setStaffDepartment(String staffDepartment) {
		this.staffDepartment = staffDepartment;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getJoinedYear() {
		return joinedYear;
	}

	public void setJoinedYear(String joinedYear) {
		this.joinedYear = joinedYear;
	}

	public Integer getNewGladFlg() {
		return newGladFlg;
	}

	public void setNewGladFlg(Integer newGladFlg) {
		this.newGladFlg = newGladFlg;
	}

}
