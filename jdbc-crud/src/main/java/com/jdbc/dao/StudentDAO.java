package com.jdbc.dao;

import java.util.List;

import com.jdbc.model.Student;

public interface StudentDAO {
	
	public void insert(Student student);
	
	public void update(Student student);
	
	
	
	
	public void delete(Integer id);
	
	public List<Student> getListAllStudent();

}
