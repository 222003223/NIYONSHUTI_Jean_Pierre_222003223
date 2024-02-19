package otherExamples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ReadandSave {
	
	public static void main(String[] args) {
		        // JDBC URL, username, and password of MySQL server
		        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223";
		        String user = "root";
		        String password = "";

		        // SQL query to retrieve data
		        String sql = "SELECT last_name,first_name, email,contact,position,Club_id,country,date_of_birth FROM player";

		        try (
		            // Establish the 
		            Connection co = DriverManager.getConnection(url, user, password);

		            // Create a prepared statement
		            PreparedStatement stm = co.prepareStatement(sql);
		            
		            // Execute the query and get the result set
		            ResultSet resultSet = stm.executeQuery();
		        ) {
		            // Get the number of rows in the result set
		            resultSet.last();
		            int rowCount = resultSet.getRow();
		            resultSet.beforeFirst();

		            // Define a 2D array of objects
		            Object[][] data = new Object[rowCount][7];

		            // Process the result set and save data into the array
		            int row = 0;
		            while (resultSet.next()) {
		                String column1Value = resultSet.getString("last_name");
		                String column2Value = resultSet.getString("first_name");
		                String column3Value = resultSet.getString("email");
		                String column4Value = resultSet.getString("contact");
		                String column5Value = resultSet.getString("position");
		                String column6Value = resultSet.getString("club_id");
		                String column7Value = resultSet.getString("country");
		                String column8Value = resultSet.getString("date_of_birth");

		                // Save data into the 2D array
		                data[row][0] = column1Value;
		                data[row][1] = column2Value;
		                data[row][2] = column3Value;
		                data[row][3] = column4Value;
		                data[row][4] = column5Value;
		                data[row][5] = column6Value;
		                data[row][6] = column7Value;
		                data[row][7] = column8Value;

		                row++;
		            }

		            // Print or use the data from the 2D array
		            for (Object[] rowArray : data) {
		                for (Object value : rowArray) {
		                    System.out.print(value + " ");
		                }
		                System.out.println();
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
}
