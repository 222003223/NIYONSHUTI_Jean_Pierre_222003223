package otherExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Selectdata {
	
		public class SelectStudentExample {
		    public static void main(String[] args) {
		        // JDBC URL, username, and password of MySQL server
		        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223";
		        String user = "root";
		        String password = "";

		        // SQL query to select all columns from student where id = ?
		        String sql = "SELECT * FROM player WHERE id = ?";

		        try (
		            // Establish the connection
		            Connection connection = DriverManager.getConnection(url, user, password);

		            // Create a prepared statement
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		        ) {
		            // Set the value for the parameterized query
		            int playeer_id = 1; // Replace with the desired student id
		            preparedStatement.setInt(1, playeer_id);

		            // Execute the query and get the result set
		            ResultSet resultSet = preparedStatement.executeQuery();

		            // Process the result set
		            while (resultSet.next()) {
		                int id = resultSet.getInt("playeer_id");
		                String fname = resultSet.getString("last_name");
		                String lname = resultSet.getString("first_name");
		                String email = resultSet.getString("email");
		                String telephone = resultSet.getString("contact");
		                String po = resultSet.getString("position");
		                String cl=resultSet.getString("club_id");
						String c=resultSet.getString("country");
						String dob=resultSet.getString("date_of_birth");
						String mid=resultSet.getString("match_id");

		                // Print or use the retrieved data
		                System.out.println("Playeer_id: " + id);
		                System.out.println("First Name: " + fname);
		                System.out.println("Last Name: " + lname);
		                System.out.println("Email: " + email);
		                System.out.println("Telephone: " + telephone);
		                System.out.println("Gender: " + po);
		                System.out.println("Last Name: " + cl);
		                System.out.println("Email: " + c);
		                System.out.println("Telephone: " + dob);
		                System.out.println("Gender: " + mid);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}


	}
