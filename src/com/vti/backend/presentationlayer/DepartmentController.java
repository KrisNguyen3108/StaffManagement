package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.DepartmentService;
import com.vti.backend.businesslayer.IDepartmentService;
import com.vti.entity.Department;

public class DepartmentController {
	private IDepartmentService departmentService;

	public DepartmentController() throws FileNotFoundException, IOException {
		departmentService = new DepartmentService();
	}

	public List<Department> getListDepartments() throws ClassNotFoundException, SQLException {
		return departmentService.getListDepartments();
	}

	public Department getDepartmentById(int findID) throws ClassNotFoundException, SQLException {
		return departmentService.getDepartmentById(findID);
	}

	public boolean checkDepartmentNameExists(String findName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.checkDepartmentNameExists(findName);
	}

	public Department getDepartmentByName(String findName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.getDepartmentByName(findName);
	}

	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.createDepartment(name);
	}

	public boolean updateDepartment(int id, String newName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.updateDepartment(id, newName);
	}

	public boolean checkDepartmentIdExists(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.checkDepartmentIdExists(id);
	}

	public boolean deleteDepartmentById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentService.deleteDepartmentById(id);
	}

}
