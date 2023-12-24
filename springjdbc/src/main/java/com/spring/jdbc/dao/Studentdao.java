package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entites.Student;

public interface Studentdao {
	public int insert(Student student);
	public int change(Student student);
	public int delete(int StudentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();

}
