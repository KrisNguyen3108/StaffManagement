package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.utils.ScannerUltis;

public class Program1 {
	public static void main(String[] args)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
//		GroupFunction.getListGroups();
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Account management");
			System.out.format(leftAlignFormat, "2. Department management");
			System.out.format(leftAlignFormat, "3. Position management");
			System.out.format(leftAlignFormat, "4. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			int choose = ScannerUltis.inputIntPositive();
			switch (choose) {
			case 1:
				MenuAccount();
				break;
			case 2:
				MenuDepartment();
				break;
			case 3:
				MenuPosition();
				break;
			case 4:

				return;

			default:
				System.out.println("Nhập sai, vui lòng chọn lại.");
				break;
			}
		}

	}

	private static void MenuDepartment()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {

		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Read data – get list departments");
			System.out.format(leftAlignFormat, "2. Read data – get department by id");
			System.out.format(leftAlignFormat, "3. Check data exists – check department name exists");
			System.out.format(leftAlignFormat, "4. Create data – create department");
			System.out.format(leftAlignFormat, "5. Update data – update department");
			System.out.format(leftAlignFormat, "6. Delete date – delete by ID");
			System.out.format(leftAlignFormat, "7. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			int chooseDep = ScannerUltis.inputIntPositive();
			switch (chooseDep) {
			case 1:
				DepartmentFunction.getListDepartments();
				break;
			case 2:
				DepartmentFunction.getDepartmentById();
				break;
			case 3:
				DepartmentFunction.checkDepartmentNameExists();
				break;
			case 4:
				DepartmentFunction.createDepartment();
				break;
			case 5:
				DepartmentFunction.updateDepartment();
				break;
			case 6:
				DepartmentFunction.deleteDepartmentById();
				break;
			case 7:

				return;
			default:
				System.err.println("Nhập sai, nhập lại.");
				break;
			}
		}
	}

	private static void MenuPosition() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Read data – get list positions");
			System.out.format(leftAlignFormat, "2. Read data – get position by id");
			System.out.format(leftAlignFormat, "3. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			int choosePos = ScannerUltis.inputIntPositive();
			switch (choosePos) {
			case 1:
				PositionFunction.getListPositions();
				break;
			case 2:
				PositionFunction.getPositionById();
				break;
			case 3:

				return;
			default:
				System.err.println("Nhập sai, nhập lại.");
				break;
			}
		}
	}

	private static void MenuAccount() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Read data – get list accounts");
			System.out.format(leftAlignFormat, "2. Read data – get account by id");
			System.out.format(leftAlignFormat, "3. Check data exists – check account userName exists");
			System.out.format(leftAlignFormat, "4. Create data – create account");
			System.out.format(leftAlignFormat, "5. Update data – update account");
			System.out.format(leftAlignFormat, "6. Delete date – delete account by ID");
			System.out.format(leftAlignFormat, "7. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			int chooseAcc = ScannerUltis.inputIntPositive();
			switch (chooseAcc) {
			case 1:
				AccountFunction.getListAccounts();
				break;
			case 2:
				AccountFunction.getAccountById();
				break;
			case 3:
				AccountFunction.checkAccountNameExists();
				break;
			case 4:
				AccountFunction.createAccount();
				break;
			case 5:
				AccountFunction.updateAccount();
				break;
			case 6:
				AccountFunction.deleteAccountById();
				break;
			case 7:

				return;
			default:
				System.err.println("Nhập sai, nhập lại.");
				break;

			}
		}
	}

}
