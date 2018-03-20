package Controller;

import java.util.List;

import Model.Person;

public interface PersonIF {
	
	List<Person> findAll();
	Person findById(int id);
	Person updatePerson(int id, int groupId);
	
}
