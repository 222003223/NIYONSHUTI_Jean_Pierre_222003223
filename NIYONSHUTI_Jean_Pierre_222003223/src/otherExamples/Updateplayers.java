package otherExamples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Updateplayers {
	public class UpdateDataExample {
		    public static void main(String[] args) {
		        // JDBC URL, username, and password of MySQL server
		        String url = "jdbc:mysql://localhost/bithuye";
		        String user = "root";
		        String password = "";

		        // SQL query to update data
		        String sql = "UPDATE student SET fname = ?, lname = ?,email = ?, telephone = ?, gender=? WHERE id = ?";

		        try (
		            // Establish the con
		            Connection con = DriverManager.getConnection(url, user, password);

		            // Create a prepared statement
		            PreparedStatement stm = con.prepareStatement(sql);
		        ) {
		            // Set the new values for the update
		            stm.setString(1, "Jackson");
		            stm.setString(2, "Murazeyesu");
		            stm.setString(3, "mjackson@gmail.com"); // Assuming there is a column named 'id' for the WHERE clause
		            stm.setString(4, "078900000");
		            stm.setString(5, "Female");
		            stm.setInt(6, 3);
		            // Execute the update
		            int rowsAffected = stm.executeUpdate();

		            // Check the result
		            if (rowsAffected > 0) {
		                System.out.println("Data updated successfully!");
		            } else {
		                System.out.println("Failed to update data. No matching record found.");
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}
}
