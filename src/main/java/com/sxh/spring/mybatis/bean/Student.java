package com.sxh.spring.mybatis.bean;

public class Student {
	private int studentid;
	private String studentname;
	private int studentage;
	private String studentphone;
	public Student() {
		super();
	}
	public Student(int studentid, String studentname, int studentage, String studentphone) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentage = studentage;
		this.studentphone = studentphone;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getStudentage() {
		return studentage;
	}
	public void setStudentage(int studentage) {
		this.studentage = studentage;
	}
	public String getStudentphone() {
		return studentphone;
	}
	public void setStudentphone(String studentphone) {
		this.studentphone = studentphone;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", studentage=" + studentage
				+ ", studentphone=" + studentphone + "]";
	}
}
