package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Position;

public interface IPositionRepository {

	List<Position> getListPositions() throws SQLException, ClassNotFoundException;

	Position getPositionById(int findID) throws SQLException, ClassNotFoundException;

	boolean checkPositionIdExists(int posID) throws SQLException, ClassNotFoundException;

}
