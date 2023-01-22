package com.spring.jdbc.dao;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insert(Student student) {
		
		String query = "INSERT into student(id,name,city) values(?,?,?)";
		
		int r = this.template.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public int change(Student student) {
		
		// update query
		
		String query = "UPDATE student set name=?, city=? where id=?";
		
		int r = this.template.update(query, student.getName(), student.getCity(), student.getId());
		
		return r;
	}

	public int delete(int studentId) {
		
		// Delete operation
		
		String query = "DELETE from student where id=?";
		
		int r = this.template.update(query, studentId);
		
		return r;
	}

	public Student getStudent(int studentId) {
		
		// Selecting single student data
		
		String query = "SELECT * from student where id=?";
		
		RowMapper<Student> rowMapper = new RowMapperInpl();
		
		Student student = this.template.queryForObject(query, rowMapper, studentId);
		
		
		return student;
	}

	public List<Student> getAllStudents() {
		
		// Selecting multiple rows from the database
		
		String query = "SELECT * from student";
		
		List<Student> students = this.template.query(query, new RowMapperInpl());
		
		return students;
	}
	

}
