package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Clubs {
	    private int Clubs_id;
	    private String name;
	    private String city;
	    private String league;
	    private String stadium_name;
	    private String league_id;

	    public Clubs() {}

	    public Clubs(int Clubs_id, String name, String city, String league, String stadium_name, String league_id) {
	        this.Clubs_id = Clubs_id;
	        this.name = name;
	        this.city = city;
	        this.league = league;
	        this.stadium_name = stadium_name;
	        this.league_id = league_id;
	    }

	    public int getClubs_id() {
	        return Clubs_id;
	    }

	    public void setClubs_id(int Clubs_id) {
	        this.Clubs_id = Clubs_id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public String getLeague() {
	        return league;
	    }

	    public void setLeague(String league) {
	        this.league = league;
	    }

	    public String getStadium_name() {
	        return stadium_name;
	    }

	    public void setStadium_name(String stadium_name) {
	        this.stadium_name = stadium_name;
	    }

	    public String getLeague_id() {
	        return league_id;
	    }

	    public void setLeague_id(String league_id) {
	        this.league_id = league_id;
	    }

	    private Connection getConnection() throws SQLException {
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	        String user = "222003223";
	        String password = "222003223";
	        return DriverManager.getConnection(url, user, password);
	    }

	    public void insertData() {
	        String sql = "INSERT INTO club(name, city, league, stadium_name, league_id) VALUES (?, ?, ?, ?, ?)";

	        try (Connection con = getConnection();
	             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, city);
	            preparedStatement.setString(3, league);
	            preparedStatement.setString(4, stadium_name);
	            preparedStatement.setString(5, league_id);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Failed to insert data!", "After insert", JOptionPane.ERROR_MESSAGE);
	            }

	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public void readWithID(int inputId) {
	        String sql = "SELECT * FROM club WHERE club_id = ?";

	        try (Connection con = getConnection();
	             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

	            preparedStatement.setInt(1, inputId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                this.setClubs_id(resultSet.getInt("Club_id"));
	                this.setName(resultSet.getString("name"));
	                this.setCity(resultSet.getString("city"));
	                this.setLeague(resultSet.getString("league"));
	                this.setStadium_name(resultSet.getString("stadium_name"));
	                this.setLeague_id(resultSet.getString("league_id"));
	            }

	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public void update(int inputId) {
	        String sql = "UPDATE club SET name = ?, city = ?, league = ?, stadium_name = ?, league_id = ? WHERE club_id = ?";

	        try (Connection con = getConnection();
	             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

	            preparedStatement.setString(1, this.getName());
	            preparedStatement.setString(2, this.getCity());
	            preparedStatement.setString(3, this.getLeague());
	            preparedStatement.setString(4, this.getStadium_name());
	            preparedStatement.setString(5, this.getLeague_id());
	            preparedStatement.setInt(6, inputId);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Failed to update data!", "After update", JOptionPane.ERROR_MESSAGE);
	            }

	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public void delete(int inputId) {
	        String sql = "DELETE FROM club WHERE club_id = ?";

	        try (Connection con = getConnection();
	             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

	            preparedStatement.setInt(1, inputId);
	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Failed to delete data!", "After delete", JOptionPane.ERROR_MESSAGE);
	            }

	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

