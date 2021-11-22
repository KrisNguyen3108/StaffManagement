package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.GroupController;
import com.vti.entity.Group;

public class GroupFunction {

	public static void getListGroups() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Thông tin về các group đang có trên hệ thống: ");
		GroupController groupController = new GroupController();
		List<Group> listGroup1 = groupController.getListGroups();
		for (Group group : listGroup1) {
			System.out.println(group.toString());
		}
	}

}
