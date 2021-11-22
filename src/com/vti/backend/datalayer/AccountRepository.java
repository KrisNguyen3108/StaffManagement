package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.jdbcUltis;

public class AccountRepository implements IAccountRepository {
	private jdbcUltis jdbc;

	public AccountRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Account> getListAccounts()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		List<Account> listAcc = new ArrayList<Account>();
		String sql = "SELECT * FROM `Account` ORDER BY AccountID ASC;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			Account account = new Account();
			account.setId(resultSet.getInt(1));
			account.setEmail(resultSet.getString(2));
			account.setUsername(resultSet.getString(3));
			account.setFullName(resultSet.getString(4));

			DepartmentRepository departmentRepository = new DepartmentRepository();
			Department department = departmentRepository.getDepartmentById(resultSet.getInt(5));
			account.setDepartment(department);

			PositionRepository positionRepository = new PositionRepository();
			Position position = positionRepository.getPositionById(resultSet.getInt(6));
			account.setPosition(position);

			account.setCreateDate(resultSet.getDate(7).toLocalDate());
			listAcc.add(account);
		}
		jdbc.disConnection();
		return listAcc;
	}

	@Override
	public Account getAccountById(int findID)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM `Account` WHERE AccountID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, findID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Account account = new Account();
			account.setId(resultSet.getInt(1));
			account.setEmail(resultSet.getString(2));
			account.setUsername(resultSet.getString(3));
			account.setFullName(resultSet.getString(4));

			DepartmentRepository departmentRepository = new DepartmentRepository();
			Department department = departmentRepository.getDepartmentById(resultSet.getInt(5));
			account.setDepartment(department);

			PositionRepository positionRepository = new PositionRepository();
			Position position = positionRepository.getPositionById(resultSet.getInt(6));
			account.setPosition(position);

			account.setCreateDate(resultSet.getDate(7).toLocalDate());
			return account;
		} else {
			jdbc.disConnection();
			return null;
		}
	}

	@Override
	public boolean checkAccountNameExists(String findUserName) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM `Account` WHERE (Username = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, findUserName);
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
	public Account getAccountByUserName(String findUserName)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM `Account` WHERE Username = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, findUserName);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Account account = new Account();
			account.setId(resultSet.getInt(1));
			account.setEmail(resultSet.getString(2));
			account.setUsername(resultSet.getString(3));
			account.setFullName(resultSet.getString(4));

			DepartmentRepository departmentRepository = new DepartmentRepository();
			Department department = departmentRepository.getDepartmentById(resultSet.getInt(5));
			account.setDepartment(department);

			PositionRepository positionRepository = new PositionRepository();
			Position position = positionRepository.getPositionById(resultSet.getInt(6));
			account.setPosition(position);

			account.setCreateDate(resultSet.getDate(7).toLocalDate());
			return account;
		} else {
			jdbc.disConnection();
			return null;
		}
	}

	@Override
	public boolean createAccount(Account account, int depId, int posId) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO `Account` (Email, Username, FullName, DepartmentID, PositionID, CreateDate) "
				+ "VALUES (?, ?, ?, ?, ?, now());";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, account.getEmail());
		preparedStatement.setString(2, account.getUsername());
		preparedStatement.setString(3, account.getFullName());
		preparedStatement.setInt(4, depId);
		preparedStatement.setInt(5, posId);
		if (preparedStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean checkAccountEmailExists(String email) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM `Account` WHERE (Email = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
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
	public boolean checkAccountIdExists(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM `Account` WHERE (AccountID = ?);";
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
	public boolean updateAccountPositionID(int id, int posId) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `Account` SET PositionID = ? WHERE AccountID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, posId);
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
	public boolean updateAccountEmail(int id, String newEmail) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `Account` SET Email = ? WHERE AccountID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, newEmail);
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
	public boolean updateAccountUsername(int id, String newUserName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `Account` SET Username = ? WHERE AccountID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, newUserName);
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
	public boolean updateAccountFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `Account` SET FullName = ? WHERE AccountID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, newFullName);
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
	public boolean updateAccountDepartmentID(int id, int depId) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `Account` SET DepartmentID = ? WHERE AccountID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, depId);
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
	public boolean deleteAccountById(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM `Account` WHERE AccountID = ?;";
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
