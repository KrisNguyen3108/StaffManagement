package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Position;

public interface IPositionService {

	List<Position> getListPositions() throws ClassNotFoundException, SQLException;

	Position getPositionById(int findID) throws ClassNotFoundException, SQLException;

	boolean checkPositionIdExists(int posID) throws ClassNotFoundException, SQLException;

}
