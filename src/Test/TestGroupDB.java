package Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import Database.GroupStorage;
import Database.PersonStorage;
import Model.Group;
import Model.Person;

public class TestGroupDB {
	
	private GroupStorage groupStorage;

	public TestGroupDB() {
		groupStorage = new GroupStorage();
	}
	
	@Test
	public void testfindAll() {
		try {
			List<Group> groups = groupStorage.findAll();
			assertTrue(groups.size() >= 1); 
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}

	@Test
	public void testFindById() {
		try {
			Group group = groupStorage.findById(1);
			assertNotNull(group);
			assertNotNull(group.getName());
			System.out.println(group.getName());
			// ...
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
