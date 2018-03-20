package Database;

import java.sql.SQLException;
import java.util.List;

import Model.Person;

public interface PersonStorageIF {
	
	List<Person> findAll() throws SQLException;
	Person findById(int id) throws SQLException;
	Person updatePerson(String email, String phone, String birthDate, int groupId) throws SQLException;

}
