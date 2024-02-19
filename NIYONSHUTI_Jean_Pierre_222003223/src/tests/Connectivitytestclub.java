package tests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Connectivitytestclub {
	    public static void main(String[] args) {
	        Connection co = null;
	        PreparedStatement stm = null;
	        ResultSet rs = null;
	        String sql = "SELECT * FROM club";
	        String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223";
	        String user = "root";
	        String pass = "";

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            co = DriverManager.getConnection(host, user, pass);
	            stm = co.prepareStatement(sql);
	            rs = stm.executeQuery();

	            while (rs.next()) {
	                String id = rs.getString("club_id");
	                String n = rs.getString("name");
	                String ci = rs.getString("city");
	                Object le = rs.getObject("league");
	                String st = rs.getString("stadium_name");
	                String lid = rs.getString("league_id");
	                System.out.println(id + "\t" + n + "\t" + ci + "\t" + le + "\t" + st + "\t" + lid + "\t");
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

