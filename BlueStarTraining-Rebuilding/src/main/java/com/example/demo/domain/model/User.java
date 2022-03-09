package com.example.demo.domain.model;

public class User {

	private String staffCode;
	private String lastName;
	private String firstName;
	private String lastNameRomaji;
	private String firstNameRomaji;
	private String staffDepartment;
	private String projectType;
	private String joinedYear;
	private Boolean newGladFlg;

	public String getstaffCode() {
		return staffCode;
	}

	public void setstaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastNameRomaji() {
		return lastNameRomaji;
	}

	public void setlastNameRomaji(String lastNameRomaji) {
		this.lastNameRomaji = lastNameRomaji;
	}

	public String getfirstNameRomaji() {
		return firstNameRomaji;
	}

	public void setfirstNameRomaji(String firstNameRomaji) {
		this.firstNameRomaji = firstNameRomaji;
	}

	public String getstaffDepartment() {
		return staffDepartment;
	}

	public void setstaffDepartment(String staffDepartment) {
		this.staffDepartment = staffDepartment;
	}

	public String getprojectType() {
		return projectType;
	}

	public void setprojectType(String projectType) {
		this.projectType = projectType;
	}

	public String getjoinedYear() {
		return joinedYear;
	}

	public void setjoinedYear(String joinedYear) {
		this.joinedYear = joinedYear;
	}

	public Boolean getnewGladFlg() {
		return newGladFlg;
	}

	public void setnewGladFlg(Boolean newGladFlg) {
		this.newGladFlg = newGladFlg;
	}

}
