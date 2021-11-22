package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IPositionService;
import com.vti.backend.businesslayer.PositionService;
import com.vti.entity.Position;

public class PositionController {
	private IPositionService positionService;

	public PositionController() throws FileNotFoundException, IOException {
		positionService = new PositionService();
	}

	public Position getPositionById(int findID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return positionService.getPositionById(findID);
	}

	public List<Position> getListPositions() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return positionService.getListPositions();
	}

	public boolean checkPositionIdExists(int posID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return positionService.checkPositionIdExists(posID);
	}

}
