package com.sxh.spring.mybatis.dao;

import java.util.List;

import com.sxh.spring.mybatis.bean.Student;

public interface StudentMapper {
	Student selectStudentById(int studentId);
	Student selectStudentByIdName(Student student);
	List<Student> selectStudentsById(int studentId);
	void insertStudent(Student student);
}
