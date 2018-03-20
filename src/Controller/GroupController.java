package Controller;

import java.util.List;

import Database.GroupStorage;
import Model.Group;

public class GroupController implements GroupIF {
	
	private GroupStorage groupStorage;
	
	public GroupController() {
		this.groupStorage = new GroupStorage();
	}

	@Override
	public List<Group> findAll() {
		return groupStorage.findAll();
	}

	@Override
	public Group findById(int id) {
		return groupStorage.findById(id);
	}

}
