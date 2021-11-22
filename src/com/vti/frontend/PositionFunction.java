package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.PositionController;
import com.vti.entity.Position;
import com.vti.utils.ScannerUltis;

public class PositionFunction {

	public static void getListPositions()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		PositionController positionController = new PositionController();
		System.out.println("Thông tin tất cả position hiện có trên hệ thống:");
		List<Position> listPos1 = positionController.getListPositions();
		for (Position position : listPos1) {
			System.out.println(position.toString());
		}
	}

	public static void getPositionById()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		PositionController positionController = new PositionController();
		System.out.println("Mời bạn nhập vào ID của position bạn cần tìm: ");
		int findID = ScannerUltis.inputIntPositive();
		System.out.println("Thông tin position cần tìm: ");
		Position position = positionController.getPositionById(findID);
		if (position != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | PositionName        |%n");
			System.out.format("+--------+-----------------------+%n");

			System.out.format(leftAlignFormat, position.getId(), position.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Cannot find position which has id =" + findID);
		}
	}

}
