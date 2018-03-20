package Database;

import java.sql.SQLException;
import java.util.List;

import Model.Group;

public interface GroupStorageIF {
	
	List<Group> findAll() throws SQLException;
	Group findById(int id) throws SQLException;

}
