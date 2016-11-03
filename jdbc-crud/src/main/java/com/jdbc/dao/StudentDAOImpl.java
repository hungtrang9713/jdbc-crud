package com.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.connection.JDBCConnection;
import com.jdbc.model.Student;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public void insert(Student student) {
		try {
            String query = "insert into student (id, name, age) values (?,?,?)";
            PreparedStatement preparedStatement = JDBCConnection.getConnection().prepareStatement( query );
            preparedStatement.setInt(1, student.getId() );
            preparedStatement.setString( 2, student.getName() );
            preparedStatement.setInt(3, student.getAge() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	@Override
	public void update(Student student) {
		try {
            String query = "update student set name=?, age=? where id=?";
            PreparedStatement preparedStatement = JDBCConnection.getConnection().prepareStatement( query );
            preparedStatement.setString( 1, student.getName() );
            preparedStatement.setInt( 2, student.getAge() );
            preparedStatement.setInt( 3, student.getId() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	@Override
	public void delete(Integer id) {
		try {
            String query = "delete from student where id=?";
            PreparedStatement preparedStatement = JDBCConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	@Override
	public List<Student> getListAllStudent() {
		List<Student> students = new ArrayList<Student>();
        try {
            Statement statement = JDBCConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while( resultSet.next() ) {
                Student student = new Student();
                student.setId(resultSet.getInt( "id" ) );
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                students.add(student);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
	}

}
