package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entites.Student;

@Component("studentdao")
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class StudentDaoImpl implements Studentdao {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		   // Insert Query
	      
	      String query="insert into student(id,name,city) values(?,?,?)";
	     int r= this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	@Override
	public int change(Student student) {
		// Updating Data
		String query="update student set name=?,city=? where id=?";
		int res = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return res;
	}
	
	@Override
	public int delete(int StudentId) {
		// Delete Operation
		String query="delete from student where id=?";
		int r = this.jdbcTemplate.update(query,StudentId);
		return r;
	}
  
	@Override
	public Student getStudent(int studentId) {
		// Selecting Single Student Data
		String query="select * from student where id=?";
		RowMapper<Student>rowMapper=new RowMapperImpl();
	     Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);	
		return student;
	}
	
	@Override
	public List<Student> getAllStudents() {
		// Selecting Multiple Student
		String query="select * from student";
		List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
		return  students;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



}
