package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.backend.presentationlayer.PositionController;
import com.vti.entity.Account;
import com.vti.utils.ScannerUltis;

public class AccountFunction {

	public static void getListAccounts()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AccountController accountController = new AccountController();
		System.out.println("Thông tin tất cả account hiện có trên hệ thống:");
		List<Account> listAcc1 = accountController.getListAccounts();
		for (Account account : listAcc1) {
			System.out.println(account);
		}

	}

	public static void getAccountById()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		AccountController accountController = new AccountController();
		System.out.println("Mời bạn nhập vào ID của account bạn cần tìm: ");
		int findID = ScannerUltis.inputIntPositive();
		System.out.println("Thông tin Account cần tìm: ");
		Account account = accountController.getAccountById(findID);
		if (account != null) {
			System.out.println(account.toString());
		} else {
			System.out.println("Cannot find account which has id =" + findID);
		}

	}

	public static void checkAccountNameExists()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AccountController accountController = new AccountController();
		System.out.println("Mời bạn nhập vào userName của account cần tìm: ");
		String findUserName = ScannerUltis.inputString();
		boolean checkUserName = accountController.checkAccountNameExists(findUserName);
		Account account = accountController.getAccountByUserName(findUserName);
		if (checkUserName) {
			System.out.println(account.toString());
		} else {
			System.out.println("Không có account bạn cần tìm trên hệ thống");
		}

	}

	public static void createAccount() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		AccountController accountController = new AccountController();
		Account account = new Account();
		account.setEmail(getEmail());
		account.setUsername(getUserName());
		System.out.println("Mời bạn nhập vào fullname cho account cần tạo: ");
		account.setFullName(ScannerUltis.inputString());
		int depId = getDepId();
		int posId = getPosId();
		if (accountController.createAccount(account, depId, posId)) {
			System.out.println("Tạo thành công.");
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}

	private static String getEmail() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		AccountController accountController = new AccountController();
		while (true) {
			System.out.println("Mời bạn nhập vào email cho account cần tạo: ");
			String email = ScannerUltis.inputString();
			if (accountController.checkAccountEmailExists(email)) {
				System.out.println("This email is Exists!");
			} else {
				return email;
			}
		}
	}

	private static String getUserName()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		AccountController accountController = new AccountController();
		while (true) {
			System.out.println("Mời bạn nhập vào userName cho account cần tạo: ");
			String userName = ScannerUltis.inputString();
			if (accountController.checkAccountNameExists(userName)) {
				System.out.println("This userName is Exists!");
			} else {
				return userName;
			}
		}
	}

	private static int getDepId() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		while (true) {
			DepartmentFunction.getListDepartments();
			System.out.println("Mời bạn chọn DepartmentID cho account cần tạo: ");
			int depID = ScannerUltis.inputIntPositive();
			if (departmentController.checkDepartmentIdExists(depID)) {
				return depID;
			} else {
				System.out.println("DepartmentID bạn vừa chọn không có trên hệ thống, vui lòng kiểm tra lại.");
			}
		}
	}

	private static int getPosId() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		PositionController positionController = new PositionController();
		while (true) {
			PositionFunction.getListPositions();
			System.out.println("Mời bạn chọn PositionID cho account cần tạo: ");
			int posID = ScannerUltis.inputIntPositive();
			if (positionController.checkPositionIdExists(posID)) {
				return posID;
			} else {
				System.out.println("PositionID bạn vừa chọn không có trên hệ thống");
			}
		}
	}

	public static void updateAccount() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AccountController accountController = new AccountController();
		while (true) {
			System.out.println("Bạn muốn update theo field nào");
			System.out.println("1.Email, 2.UserName, 3.FullName, 4.Department, 5.Position, 6.Exit ");
			int choose = ScannerUltis.inputIntPositive();
			switch (choose) {
			case 1:
				int id1 = getAccIDUpdate();
				String newEmail = getNewEmailForUpdateAccount();
				if (accountController.updateAccountEmail(id1, newEmail)) {
					System.out.println("Đã update thành công.");
					getListAccounts();
				} else {
					System.out.println("Đã có lỗi xảy ra");
				}
				break;
			case 2:
				int id2 = getAccIDUpdate();
				String newUserName = getNewUserNameForUpdateAccount();
				if (accountController.updateAccountUsername(id2, newUserName)) {
					System.out.println("Đã update thành công.");
					getListAccounts();
				} else {
					System.out.println("Đã có lỗi xảy ra");
				}
				break;
			case 3:
				int id3 = getAccIDUpdate();
				String newFullName = ScannerUltis.inputString();
				if (accountController.updateAccountFullName(id3, newFullName)) {
					System.out.println("Đã update thành công.");
					getListAccounts();
				} else {
					System.out.println("Đã có lỗi xảy ra");
				}
				break;
			case 4:
				int id4 = getAccIDUpdate();
				int depId = getNewDepIdForUpdateAccount();
				if (accountController.updateAccountDepartmentID(id4, depId)) {
					System.out.println("Đã update thành công.");
					getListAccounts();
				} else {
					System.out.println("Đã có lỗi xảy ra");
				}
				break;
			case 5:
				int id5 = getAccIDUpdate();
				int posId = getNewPosIdForUpdateAccount();
				if (accountController.updateAccountPositionID(id5, posId)) {
					System.out.println("Đã update thành công.");
					getListAccounts();
				} else {
					System.out.println("Đã có lỗi xảy ra");
				}
				break;
			case 6:
				return;
			default:
				System.out.println("Gía trị bạn vừa nhập không phù hợp, xin mời nhập lại.");
				break;
			}
		}

	}

	private static int getNewPosIdForUpdateAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		PositionController positionController = new PositionController();
		while (true) {
			System.out.println("Mời bạn nhập vào new PositionID cho account bạn cần update");
			int newPosId = ScannerUltis.inputIntPositive();
			if (positionController.checkPositionIdExists(newPosId)) {
				return newPosId;
			} else {
				System.out.println("PositionID bạn vừa nhập không có trên hệ thống.");
			}
		}
	}

	private static int getNewDepIdForUpdateAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentController departmentController = new DepartmentController();
		while (true) {
			System.out.println("Mời bạn nhập vào new DepartmentID cho account bạn cần update");
			int newDepId = ScannerUltis.inputIntPositive();
			if (departmentController.checkDepartmentIdExists(newDepId)) {
				return newDepId;
			} else {
				System.out.println("DepartmentID bạn vừa nhập không có trên hệ thống.");
			}
		}
	}

	private static String getNewUserNameForUpdateAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		AccountController accountController = new AccountController();
		while (true) {
			System.out.println("Mời bạn nhập vào new userName cho account bạn cần update");
			String newUserName = ScannerUltis.inputString();
			if (accountController.checkAccountNameExists(newUserName) == false) {
				return newUserName;
			} else {
				System.out.println("UserName này đã tồn tại trên hệ thống, mời bạn nhập lại UserName khác.");
			}
		}
	}

	private static String getNewEmailForUpdateAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		AccountController accountController = new AccountController();
		while (true) {
			System.out.println("Mời bạn nhập vào new email cho account bạn cần update");
			String newEmail = ScannerUltis.inputString();
			if (accountController.checkAccountEmailExists(newEmail) == false) {
				return newEmail;
			} else {
				System.out.println("Email này đã tồn tại trên hệ thống, mời bạn nhập lại email khác.");
			}
		}
	}

	private static int getAccIDUpdate()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AccountController accountController = new AccountController();
		while (true) {
			System.out.println("Mời bạn nhập vào ID của account cần update: ");
			int id = ScannerUltis.inputIntPositive();
			if (accountController.checkAccountIdExists(id)) {
				return id;
			} else {
				System.out.println("Cannot find account which has id = " + id);
			}
		}
	}

	public static void deleteAccountById()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AccountController accountController = new AccountController();
		int id = getAccIdDel();
		if (accountController.deleteAccountById(id)) {
			System.out.println("Đã delete thành công.");
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}

	private static int getAccIdDel() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AccountController accountController = new AccountController();
		while (true) {
			System.out.println("Mời bạn nhập vào ID của account cần delete: ");
			int id = ScannerUltis.inputIntPositive();
			if (accountController.checkAccountIdExists(id)) {
				return id;
			} else {
				System.out.println("Cannot find account which has id = " + id);
			}
		}
	}

}
