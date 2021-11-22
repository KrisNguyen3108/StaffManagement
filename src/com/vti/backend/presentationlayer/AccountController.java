package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.entity.Account;

public class AccountController {
	private IAccountService accountService;

	public AccountController() throws FileNotFoundException, IOException {
		accountService = new AccountService();
	}

	public List<Account> getListAccounts()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountService.getListAccounts();
	}

	public Account getAccountById(int findID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountService.getAccountById(findID);
	}

	public boolean checkAccountNameExists(String findUserName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.checkAccountNameExists(findUserName);
	}

	public Account getAccountByUserName(String findUserName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountService.getAccountByUserName(findUserName);
	}

	public boolean checkAccountEmailExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.checkAccountEmailExists(email);
	}

	public boolean createAccount(Account account, int depId, int posId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.createAccount(account, depId, posId);
	}

	public boolean checkAccountIdExists(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.checkAccountIdExists(id);
	}

	public boolean updateAccountPositionID(int id, int posId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.updateAccountPositionID(id, posId);
	}

	public boolean updateAccountDepartmentID(int id, int depId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.updateAccountDepartmentID(id, depId);
	}

	public boolean updateAccountFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.updateAccountFullName(id, newFullName);
	}

	public boolean updateAccountUsername(int id, String newUserName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.updateAccountUsername(id, newUserName);
	}

	public boolean updateAccountEmail(int id, String newEmail) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.updateAccountEmail(id, newEmail);
	}

	public boolean deleteAccountById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountService.deleteAccountById(id);
	}

}
