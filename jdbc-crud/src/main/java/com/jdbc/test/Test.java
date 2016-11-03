package com.jdbc.test;

import java.util.List;

import com.jdbc.dao.StudentDAO;
import com.jdbc.dao.StudentDAOImpl;
import com.jdbc.model.Student;

public class Test {
	
	public static void main(String[] args) {
		// Add by trang
		Student student = new Student(1505,"nguyen van B",20);
		StudentDAO studentDAO = new StudentDAOImpl();
		studentDAO.insert(student);
//		
//		Student student = new Student(1503,"nguyen van 10",30);
//		StudentDAO studentDAO = new StudentDAOImpl();
//		studentDAO.update(student);
		
//		StudentDAO studentDAO = new StudentDAOImpl();
//		studentDAO.delete(1503);
//		
		// Update by The Anh
		
//		List<Student> listStudents = new StudentDAOImpl().getListAllStudent();
//		
//		for(Student student : listStudents){
//			System.out.println(student.getId() + ", "+student.getName() + ", "+student.getAge()+"\n");
//		}
		
	}
	

}
