package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {

	List<Account> getListAccounts() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;

	Account getAccountById(int findID) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

	boolean checkAccountNameExists(String findUserName) throws SQLException, ClassNotFoundException;

	Account getAccountByUserName(String findUserName)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

	boolean createAccount(Account account, int depId, int posId) throws SQLException, ClassNotFoundException;

	boolean checkAccountEmailExists(String email) throws SQLException, ClassNotFoundException;

	boolean checkAccountIdExists(int id) throws ClassNotFoundException, SQLException;

	boolean updateAccountPositionID(int id, int posId) throws ClassNotFoundException, SQLException;

	boolean updateAccountEmail(int id, String newEmail) throws ClassNotFoundException, SQLException;

	boolean updateAccountUsername(int id, String newUserName) throws ClassNotFoundException, SQLException;

	boolean updateAccountFullName(int id, String newFullName) throws ClassNotFoundException, SQLException;

	boolean updateAccountDepartmentID(int id, int depId) throws ClassNotFoundException, SQLException;

	boolean deleteAccountById(int id) throws ClassNotFoundException, SQLException;

}
