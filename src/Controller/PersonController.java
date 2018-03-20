package Controller;

import java.util.List;

import Database.PersonStorage;
import Model.Person;

public class PersonController implements PersonIF {
	
	private PersonStorage personStorage;

	
	public PersonController() {
		this.personStorage = new PersonStorage();
	}
	

	@Override
	public List<Person> findAll() {
		return personStorage.findAll();
	}

	@Override
	public Person findById(int id) {
		return personStorage.findById(id);
	}

	@Override
	public Person updatePerson(int id, int groupId) {
		return personStorage.updatePerson(id, groupId);
	}

}
