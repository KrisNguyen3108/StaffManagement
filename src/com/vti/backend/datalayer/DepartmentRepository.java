package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.utils.jdbcUltis;

public class DepartmentRepository implements IDepartmentRepository {
	private jdbcUltis jdbc;

	public DepartmentRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Department> getListDepartments() throws ClassNotFoundException, SQLException {
		List<Department> listDep = new ArrayList<Department>();
		String sql = "SELECT * FROM Department ORDER BY DepartmentID ASC;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt(1));
			department.setName(resultSet.getString(2));
			listDep.add(department);
		}
		return listDep;
	}

	@Override
	public Department getDepartmentById(int findID) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, findID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt(1));
			department.setName(resultSet.getString(2));
			return department;
		} else {
			jdbc.disConnection();
			return null;
		}

	}

	@Override
	public boolean checkDepartmentNameExists(String findName) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE (DepartmentName = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, findName);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public Department getDepartmentByName(String findName) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentName = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, findName);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt(1));
			department.setName(resultSet.getString(2));
			return department;
		} else {
			jdbc.disConnection();
			return null;
		}
	}

	@Override
	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Department (DepartmentName) VALUES (?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, name);
		if (preparedStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;

		}
	}

	@Override
	public boolean checkDepartmentIdExists(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE (DepartmentID = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}

	}

	@Override
	public boolean updateDepartment(int id, String newName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Department SET DepartmentName = ? WHERE (DepartmentID = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, newName);
		preparedStatement.setInt(2, id);
		if (preparedStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;

		}

	}

	@Override
	public boolean deleteDepartmentById(int id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM Department WHERE DepartmentID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		if (preparedStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;

		}
	}

}
