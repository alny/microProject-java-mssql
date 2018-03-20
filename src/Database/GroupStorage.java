package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Group;


public class GroupStorage implements GroupStorageIF {
	
	private DBConnector dbCon;
	
	public GroupStorage() {
		dbCon = new DBConnector();
	}
	

	@Override
	public List<Group> findAll() throws NullPointerException {
		List<Group> groups = new ArrayList<>();

		try (Connection connection = dbCon.getDBcon()) {
			final String sql = "SELECT * FROM GROUPS";

			try (PreparedStatement preparedStmt = connection.prepareStatement(sql)) {

				try (ResultSet rs = preparedStmt.executeQuery()) {
					while (rs.next()) {
					
						String name = rs.getString("name");
						String description = rs.getString("description");

						Group group = new Group(name, description);
						groups.add(group);
						System.out.println(group);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			
				return groups;

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public Group findById(int group_id) throws NullPointerException {

		try (Connection connection = dbCon.getDBcon()) {
			final String sql = "SELECT * FROM GROUPS WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, group_id);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String description = rs.getString("description");


					Group group = new Group(name, description);
					System.out.println(group);
				
					return group;
					
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

}
