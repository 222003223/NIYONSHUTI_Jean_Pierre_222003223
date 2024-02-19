package otherExamples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
	
	    public static void main(String[] args) {
	        try {
	            // Step 1: Load the JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Step 2: Establish a connection using the JDBC URL
	            String url = "jdbc:mysql://localhost/niyonshuti_jea_pierre_222003223";
	            String username = "root";
	            String password = "";
	            Connection connection = DriverManager.getConnection(url, username, password);

	            // Step 3: Perform database operations
	            // ...

	            // Step 4: Close the connection
	            connection.close();
	        } catch (ClassNotFoundException e) {
	            System.out.println("JDBC driver not found!");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Error connecting to the database!");
	            e.printStackTrace();
	        }
	    }
	}

