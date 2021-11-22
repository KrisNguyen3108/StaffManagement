package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Group;
import com.vti.utils.jdbcUltis;

public class GroupRepository implements IGroupRepository {
	private jdbcUltis jdbc;

	public GroupRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Group> getListGroups() throws ClassNotFoundException, SQLException {
		List<Group> listGroup = new ArrayList<Group>();
		String sql = "SELECT * FROM `Group` ORDER BY GroupID ASC;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			Group group = new Group();
			group.setId(resultSet.getInt(1));
			group.setName(resultSet.getString(2));
			listGroup.add(group);
		}
		jdbc.disConnection();
		return listGroup;
	}

}
