package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {
	private IAccountRepository accountRepository;

	public AccountService() throws FileNotFoundException, IOException {
		accountRepository = new AccountRepository();
	}

	@Override
	public List<Account> getListAccounts()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.getListAccounts();
	}

	@Override
	public Account getAccountById(int findID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.getAccountById(findID);
	}

	@Override
	public boolean checkAccountNameExists(String findUserName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.checkAccountNameExists(findUserName);
	}

	@Override
	public Account getAccountByUserName(String findUserName)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return accountRepository.getAccountByUserName(findUserName);
	}

	@Override
	public boolean checkAccountEmailExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.checkAccountEmailExists(email);
	}

	@Override
	public boolean createAccount(Account account, int depId, int posId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.createAccount(account, depId, posId);
	}

	@Override
	public boolean updateAccountEmail(int id, String newEmail) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountEmail(id, newEmail);
	}

	@Override
	public boolean updateAccountUsername(int id, String newUserName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountUsername(id, newUserName);
	}

	@Override
	public boolean updateAccountFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountFullName(id, newFullName);
	}

	@Override
	public boolean updateAccountDepartmentID(int id, int depId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountDepartmentID(id, depId);
	}

	@Override
	public boolean updateAccountPositionID(int id, int posId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountPositionID(id, posId);
	}

	@Override
	public boolean checkAccountIdExists(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.checkAccountIdExists(id);
	}

	@Override
	public boolean deleteAccountById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return accountRepository.deleteAccountById(id);
	}

}
