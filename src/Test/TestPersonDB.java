package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import Database.PersonStorage;
import Model.Person;

public class TestPersonDB {
	
	private PersonStorage personStorage;

	public TestPersonDB() {
		personStorage = new PersonStorage();
	}
	
	@Test
	public void testfindAll() {
		try {
			List<Person> persons = personStorage.findAll();
			assertTrue(persons.size() >= 1); 
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}

	@Test
	public void testFindById() {
		try {
			Person person = personStorage.findById(1);
			assertNotNull(person);
			assertNotNull(person.getName());
			System.out.println(person.getName());
			// ...
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdate() {
		try {
			Person person = personStorage.updatePerson(3, 1);
			System.out.println(person.getGroup_id());
			assertEquals(3, person.getGroup_id());
		
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
