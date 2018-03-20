package Controller;

import java.util.List;

import Model.Group;

public interface GroupIF {
	
	List<Group> findAll();
	Group findById(int id);

}
