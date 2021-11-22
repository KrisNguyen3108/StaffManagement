package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Position;
import com.vti.utils.jdbcUltis;

public class PositionRepository implements IPositionRepository {
	private jdbcUltis jdbc;

	public PositionRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public Position getPositionById(int findID) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Position WHERE PositionID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, findID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Position position = new Position();
			position.setId(resultSet.getInt(1));
			position.setName(resultSet.getString(2));
			return position;
		} else {
			jdbc.disConnection();
			return null;
		}
	}

	@Override
	public List<Position> getListPositions() throws SQLException, ClassNotFoundException {
		List<Position> listPos = new ArrayList<Position>();
		String sql = "SELECT * FROM position ORDER BY PositionID ASC;";
		ResultSet posResultSet = jdbc.executeQuery(sql);
		while (posResultSet.next()) {
			Position position = new Position();
			position.setId(posResultSet.getInt(1));
			position.setName(posResultSet.getString(2));
			listPos.add(position);
		}
		jdbc.disConnection();
		return listPos;
	}

	@Override
	public boolean checkPositionIdExists(int posID) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Position WHERE (PositionID = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, posID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

}
