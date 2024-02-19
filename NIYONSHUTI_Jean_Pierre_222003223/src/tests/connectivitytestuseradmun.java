package tests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class connectivitytestuseradmun {
	    public static void main(String[] args) {
	        Connection co = null;
	        PreparedStatement stm = null;
	        ResultSet rs = null;
	        String sql = "SELECT * FROM user_admin";
	        String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223";
	        String user = "root";
	        String pass = "";

	        try {
	            Class.forName("com.mysql.jdbc.Driver");

	            co = DriverManager.getConnection(host, user, pass);
	            stm = co.prepareStatement(sql);
	            rs = stm.executeQuery();
	            while (rs.next()) {
	                String id = rs.getString("manager_id");
	                String fn = rs.getString("last_name");
	                String ln = rs.getString("first_name");
	                String em = rs.getString("email");
	                // Avoid displaying passwords directly
	                // String pa = rs.getString("password");
	                String tel = rs.getString("contact");
	                String ma = rs.getString("manager_id");

	                System.out.println(id + "\t" + fn + "\t" + ln + "\t" + em + "\t" + "********" + "\t" + tel + "\t" + ma);
	            }
	        } catch (ClassNotFoundException e) {
	            System.out.println("Error: JDBC driver not found");
	        } catch (SQLException e) {
	            System.out.println("Error: Unable to access the database.");
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (stm != null) {
	                    stm.close();
	                }
	                if (co != null) {
	                    co.close();
	                }
	            } catch (SQLException e) {
	                System.out.println("Error: Unable to close the database connection");
	            }
	        }
	    }
	}

