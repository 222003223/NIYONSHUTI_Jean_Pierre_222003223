package otherExamples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class deletedataplayer {
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223";
	        String user = "root";
	        String password = "";
	        String sql = "DELETE FROM player WHERE playeer_id = ?";

	        try (
	            Connection con = DriverManager.getConnection(url, user, password);
	            PreparedStatement stm = con.prepareStatement(sql);
	        ) {
	            stm.setString(1, "8"); 

	            int rowsAffected = stm.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Data deleted successfully!");
	            } else {
	                System.out.println("Failed to delete data. No matching record found.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

