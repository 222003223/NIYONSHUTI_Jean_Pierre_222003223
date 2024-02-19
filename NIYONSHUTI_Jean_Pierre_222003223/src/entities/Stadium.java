package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Stadium {
	    private int studiumId;
	    private String studiumName;
	    private String capacity;
	    private String clubId;

	    // Constructors, getters, and setters

	    public Stadium() {
	    }

	    public Stadium(int studiumId, String studiumName, String capacity, String clubId) {
	        this.studiumId = studiumId;
	        this.studiumName = studiumName;
	        this.capacity = capacity;
	        this.clubId = clubId;
	    }

	    // Getters and setters

	    public int getStudiumId() {
	        return studiumId;
	    }

	    public void setStudiumId(int studiumId) {
	        this.studiumId = studiumId;
	    }

	    public String getStudiumName() {
	        return studiumName;
	    }

	    public void setStudiumName(String studiumName) {
	        this.studiumName = studiumName;
	    }

	    public String getCapacity() {
	        return capacity;
	    }

	    public void setCapacity(String capacity) {
	        this.capacity = capacity;
	    }

	    public String getClubId() {
	        return clubId;
	    }

	    public void setClubId(String clubId) {
	        this.clubId = clubId;
	    }

	    // CRUD operations

	    public void insertData() {
	        String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	        String user = "222003223";
	        String password = "222003223";

	        String sql = "INSERT INTO stadium (studium_name, capacity, club_id) VALUES (?, ?, ?)";

	        try (Connection con = DriverManager.getConnection(host, user, password);
	             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setString(1, studiumName);
	            preparedStatement.setString(2, capacity);
	            preparedStatement.setString(3, clubId);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Data inserted successfully!");
	                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                System.out.println("Failed to insert data.");
	                JOptionPane.showMessageDialog(null, "Failed to insert data!", "After insert", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Failed to insert data: " + e.getMessage(), "After insert", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public void readWithID(int inputId) {
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	        String user = "222003223";
	        String password = "222003223";

	        String sql = "SELECT * FROM stadium WHERE studium_id = ?";

	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, inputId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                this.setStudiumId(resultSet.getInt("studium_id"));
	                this.setStudiumName(resultSet.getString("studium_name"));
	                this.setCapacity(resultSet.getString("capacity"));
	                this.setClubId(resultSet.getString("club_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void update(int inputStudiumId) {
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	        String user = "222003223";
	        String password = "222003223";

	        String sql = "UPDATE stadium SET studium_name = ?, capacity = ?, club_id = ? WHERE studium_id = ?";

	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, this.getStudiumName());
	            preparedStatement.setString(2, this.getCapacity());
	            preparedStatement.setString(3, this.getClubId());
	            preparedStatement.setInt(4, inputStudiumId);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Data updated successfully!");
	            } else {
	                System.out.println("Failed to update data. No matching record found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void delete(int inputId) {
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	        String user = "222003223";
	        String password = "222003223";

	        String sql = "DELETE FROM stadium WHERE studium_id = ?";

	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, inputId);

	            int rowsAffected = preparedStatement.executeUpdate();

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
