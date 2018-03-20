package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Person;


public class PersonStorage {
	
	private DBConnector dbCon;
	
	public PersonStorage() {
		dbCon = new DBConnector();
	}
	
//	public static void main(String[] args) {
//		PersonStorage p =  new PersonStorage();
//		p.updatePerson(1, 2);
//		
//	}
	
	public List<Person> findAll() throws NullPointerException {
		List<Person> persons = new ArrayList<>();

		try (Connection connection = dbCon.getDBcon()) {
			final String sql = "SELECT * FROM PERSONS";

			try (PreparedStatement preparedStmt = connection.prepareStatement(sql)) {

				try (ResultSet rs = preparedStmt.executeQuery()) {
					while (rs.next()) {
						
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String email = rs.getString("email");
						String phone = rs.getString("phone");
						String birthDate = rs.getString("birthdate");
						int group_id = rs.getInt("group_id");

						Person person = new Person(id, name, email, phone, birthDate, group_id);
						persons.add(person);
						System.out.println(person);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			
				return persons;

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
	
	public Person findById(int person_id) throws NullPointerException {

		try (Connection connection = dbCon.getDBcon()) {
			final String sql = "SELECT * FROM PERSONS WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, person_id);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					String birthDate = rs.getString("birthDate");

					Person person = new Person(name, email, phone, birthDate);
					System.out.println(person);
				
					return person;
					
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
	
	public Person updatePerson(int getId, int newGroupId) throws NullPointerException {

		try (Connection connection = dbCon.getDBcon()) {
			final String sql = "UPDATE persons set group_id = ? WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, newGroupId);
			statement.setInt(2, getId);
			statement.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


}
