package tests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Connectivitytestbank {
	    public static void main(String[] args) {
	        Connection co = null;
	        PreparedStatement stm = null;
	        ResultSet rs = null;
	        String sql = "SELECT * FROM bank";
	        String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223";
	        String user = "root";
	        String pass = "";

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            co = DriverManager.getConnection(host, user, pass);
	            stm = co.prepareStatement(sql);
	            rs = stm.executeQuery();

	            while (rs.next()) {
	                int id = rs.getInt("bank_id");
	                String bn = rs.getString("bank_name");
	                String lc = rs.getString("location");
	                String wb = rs.getString("website");
	                String tel = rs.getString("contact");
	                String ba = rs.getString("bank_account");
	                String clid = rs.getString("club_id");
	                System.out.println(id + "\t" + bn + "\t" + lc + "\t" + wb + "\t" + tel + "\t" + ba + "\t" + clid + "\t");
	            }
	        } catch (ClassNotFoundException e) {
	            System.out.println("Error: JDBC driver not found");
	        } catch (SQLException e) {
	            System.out.println("Error: Unable to access the database");
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
