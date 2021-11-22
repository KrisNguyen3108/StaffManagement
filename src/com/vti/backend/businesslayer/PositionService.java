package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IPositionRepository;
import com.vti.backend.datalayer.PositionRepository;
import com.vti.entity.Position;

public class PositionService implements IPositionService {
	private IPositionRepository positionRepository;

	public PositionService() throws FileNotFoundException, IOException {
		positionRepository = new PositionRepository();
	}

	@Override
	public List<Position> getListPositions() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return positionRepository.getListPositions();
	}

	@Override
	public Position getPositionById(int findID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return positionRepository.getPositionById(findID);
	}

	@Override
	public boolean checkPositionIdExists(int posID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return positionRepository.checkPositionIdExists(posID);
	}

}
