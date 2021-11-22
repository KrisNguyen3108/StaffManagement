package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.IDepartmentRepository;
import com.vti.entity.Department;

public class DepartmentService implements IDepartmentService {
	private IDepartmentRepository departmentRepository;

	public DepartmentService() throws FileNotFoundException, IOException {
		departmentRepository = new DepartmentRepository();
	}

	@Override
	public List<Department> getListDepartments() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.getListDepartments();
	}

	@Override
	public Department getDepartmentById(int findID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.getDepartmentById(findID);
	}

	@Override
	public boolean checkDepartmentNameExists(String findName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.checkDepartmentNameExists(findName);
	}

	@Override
	public Department getDepartmentByName(String findName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.getDepartmentByName(findName);
	}

	@Override
	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.createDepartment(name);
	}

	@Override
	public boolean checkDepartmentIdExists(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.checkDepartmentIdExists(id);
	}

	@Override
	public boolean updateDepartment(int id, String newName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return departmentRepository.updateDepartment(id, newName);
	}

	@Override
	public boolean deleteDepartmentById(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return departmentRepository.deleteDepartmentById(id);
	}

}
