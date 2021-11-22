package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.entity.Department;
import com.vti.utils.ScannerUltis;

public class DepartmentFunction {

	public static void getListDepartments()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartmentController departmentController = new DepartmentController();
		System.out.println("Thông tin tất cả department hiện có trên hệ thống:");
		List<Department> listDep1 = departmentController.getListDepartments();
		for (Department department : listDep1) {
			System.out.println(department.toString());
		}

	}

	public static void getDepartmentById()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Mời bạn nhập vào ID của department bạn cần tìm: ");
		int findID = ScannerUltis.inputIntPositive();
		System.out.println("Thông tin Department cần tìm: ");
		DepartmentController departmentController = new DepartmentController();
		Department department = departmentController.getDepartmentById(findID);
		if (department != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | DepartmentName        |%n");
			System.out.format("+--------+-----------------------+%n");

			System.out.format(leftAlignFormat, department.getId(), department.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Cannot find department which has id =" + findID);
		}

	}

	private static int getIDDel() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		while (true) {
			System.out.println("Mời bạn nhập vào ID của department cần delete: ");
			int id = ScannerUltis.inputIntPositive();
			if (departmentController.checkDepartmentIdExists(id) == false) {
				System.out.println("Cannot find department which has id = " + id);
			} else {
				return id;
			}

		}

	}

	public static void deleteDepartmentById()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartmentController departmentController = new DepartmentController();
		int id = getIDDel();
		if (departmentController.deleteDepartmentById(id)) {
			System.out.println("Đã delete thành công.");
			getListDepartments();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}

	public static void createDepartment()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartmentController departmentController = new DepartmentController();
		String name = getName();
		if (departmentController.createDepartment(name)) {
			System.out.println("Tạo thành công.");
			getListDepartments();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}

	private static String getName() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		while (true) {
			System.out.println("Mời bạn nhập vào name của department cần tạo: ");
			String name = ScannerUltis.inputString();
			if (departmentController.checkDepartmentNameExists(name)) {
				System.out.println("Department Name is Exists!");
			} else {
				return name;
			}
		}
	}

	private static int getIDUpdate() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		while (true) {
			System.out.println("Mời bạn nhập vào ID của department cần update: ");
			int id = ScannerUltis.inputIntPositive();
			if (departmentController.checkDepartmentIdExists(id) == false) {
				System.out.println("Cannot find department which has id = " + id);
			} else {
				return id;
			}
		}

	}

	public static void updateDepartment()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartmentController departmentController = new DepartmentController();
		int id = getIDUpdate();
		String newName = getName();
		if (departmentController.updateDepartment(id, newName)) {
			System.out.println("Đã update thành công.");
			getListDepartments();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}

	public static void checkDepartmentNameExists()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartmentController departmentController = new DepartmentController();
		System.out.println("Mời bạn nhập vào name của department cần tìm: ");
		String findName = ScannerUltis.inputString();
		boolean checkDepName = departmentController.checkDepartmentNameExists(findName);
		Department department = departmentController.getDepartmentByName(findName);
		if (checkDepName) {
			System.out.println("Thông tin Department cần tìm: ");
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | DepartmentName        |%n");
			System.out.format("+--------+-----------------------+%n");

			System.out.format(leftAlignFormat, department.getId(), department.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không có department bạn cần tìm trên hệ thống");
		}

	}

}
