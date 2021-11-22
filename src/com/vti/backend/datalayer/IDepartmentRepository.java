package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentRepository {

	List<Department> getListDepartments() throws ClassNotFoundException, SQLException;

	Department getDepartmentById(int findID) throws ClassNotFoundException, SQLException;

	boolean checkDepartmentNameExists(String findName) throws ClassNotFoundException, SQLException;

	Department getDepartmentByName(String findName) throws ClassNotFoundException, SQLException;

	boolean createDepartment(String name) throws ClassNotFoundException, SQLException;

	boolean checkDepartmentIdExists(int id) throws SQLException, ClassNotFoundException;

	boolean updateDepartment(int id, String newName) throws ClassNotFoundException, SQLException;

	boolean deleteDepartmentById(int id) throws SQLException, ClassNotFoundException;

}
