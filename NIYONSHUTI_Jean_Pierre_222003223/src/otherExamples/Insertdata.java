package otherExamples;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class Insertdata{
	    public static void main(String[] args) {
	        // JDBC URL, username, and password of MySQL server
	        String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223";
	        String user = "root";
	        String password = "";

	        // SQL query to insert data
	        String sql = "INSERT INTO bank (bank_name,location,website,contact,bank_account,club_id) VALUES (?, ?, ?, ?, ?,?)";

	        try (
	            // Establish the connection
	            Connection con = DriverManager.getConnection(host, user, password);

	            // Create a prepared statement
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	        ) {
	            // Set the values for the prepared statement
	            preparedStatement.setString(1, "bank_name");
	            preparedStatement.setString(2, "location");
	            preparedStatement.setString(3, "website");
	            preparedStatement.setString(4, "contact");
	            preparedStatement.setString(5, "bank_account");
	            preparedStatement.setString(6, "club_id");
	            // Execute the query
	            float rowsAffected = preparedStatement.executeUpdate();

	            // Check the result
	            if (rowsAffected > 0) {
	                System.out.println("Data inserted successfully!");
	            } else {
	                System.out.println("Failed to insert data.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

