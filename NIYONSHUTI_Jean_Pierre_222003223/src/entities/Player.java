package entities;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class Player {
	    private int player_id;
	    private String last_name;
	    private String first_name;
	    private String email;
	    private String contact;
	    private String position;
	    private int club_id;
	    private String country;
	    private String date_of_birth;

	    public Player() {}

	    public Player(int player_id, String last_name, String first_name, String email, String contact, String position,
	            int club_id, String country, String date_of_birth) {
	        super();
	        this.player_id = player_id;
	        this.last_name = last_name;
	        this.first_name = first_name;
	        this.email = email;
	        this.contact = contact;
	        this.position = position;
	        this.club_id = club_id;
	        this.country = country;
	        this.date_of_birth = date_of_birth;
	    }

	    // Getters and setters

	    public int getPlayer_id() {
	        return player_id;
	    }

	    public void setPlayer_id(int player_id) {
	        this.player_id = player_id;
	    }

	    public String getLast_name() {
	        return last_name;
	    }

	    public void setLast_name(String last_name) {
	        this.last_name = last_name;
	    }

	    public String getFirst_name() {
	        return first_name;
	    }

	    public void setFirst_name(String first_name) {
	        this.first_name = first_name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getContact() {
	        return contact;
	    }

	    public void setContact(String contact) {
	        this.contact = contact;
	    }

	    public String getPosition() {
	        return position;
	    }

	    public void setPosition(String position) {
	        this.position = position;
	    }

	    public int getClub_id() {
	        return club_id;
	    }

	    public void setClub_id(int club_id) {
	        this.club_id = club_id;
	    }

	    public String getCountry() {
	        return country;
	    }

	    public void setCountry(String country) {
	        this.country = country;
	    }

	    public String getDate_of_birth() {
	        return date_of_birth;
	    }

	    public void setDate_of_birth(String date_of_birth) {
	        this.date_of_birth = date_of_birth;
	    }

	    // Method to insert player data into the database
	    public void insertData() {
	        String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	        String user = "222003223";
	        String password = "222003223";

	        String sql = "INSERT INTO Player (last_name, first_name, email, contact, position, club_id, country, date_of_birth) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	        try (Connection con = DriverManager.getConnection(host, user, password);
	                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
	            preparedStatement.setString(1, this.last_name);
	            preparedStatement.setString(2, this.first_name);
	            preparedStatement.setString(3, this.email);
	            preparedStatement.setString(4, this.contact);
	            preparedStatement.setString(5, this.position);
	            preparedStatement.setInt(6, this.club_id);
	            preparedStatement.setString(7, this.country);
	            preparedStatement.setString(8, this.date_of_birth);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Data inserted successfully!");
	                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert",
	                        JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                System.out.println("Failed to insert data.");
	                JOptionPane.showMessageDialog(null, "Failed to insert data.!", "After insert",
	                        JOptionPane.ERROR_MESSAGE);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Method to read player data with a given player ID
	    public void readWithID(int inputID) {
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	        String user = "222003223";
	        String password = "222003223";

	        String sql = "SELECT * FROM Player WHERE playeer_id = ?";

	        try (Connection connection = DriverManager.getConnection(url, user, password);
	                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
	            preparedStatement.setInt(1, inputID);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                this.player_id = resultSet.getInt("playeer_id");
	                this.last_name = resultSet.getString("last_name");
	                this.first_name = resultSet.getString("first_name");
	                this.email = resultSet.getString("email");
	                this.contact = resultSet.getString("contact");
	                this.position = resultSet.getString("position");
	                this.club_id = resultSet.getInt("club_id");
	                this.country = resultSet.getString("country");
	                this.date_of_birth = resultSet.getString("date_of_birth");
	            } else {
	                System.out.println("No player found with ID: " + inputID);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Method to update player data with a given player ID
	    public void update(int inputID) {
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	        String user = "222003223";
	        String password = "222003223";

	        String sql = "UPDATE Player SET last_name = ?, first_name = ?, email = ?, contact = ?, position = ?, club_id = ?, country = ?, date_of_birth = ? WHERE playeer_id = ?";

	        try (Connection connection = DriverManager.getConnection(url, user, password);
	                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
	            preparedStatement.setString(1, this.last_name);
	            preparedStatement.setString(2, this.first_name);
	            preparedStatement.setString(3, this.email);
	            preparedStatement.setString(4, this.contact);
	            preparedStatement.setString(5, this.position);
	            preparedStatement.setInt(6, this.club_id);
	            preparedStatement.setString(7, this.country);
	            preparedStatement.setString(8, this.date_of_birth);
	            preparedStatement.setInt(9, inputID);

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

	    // Method to delete player data with a given player ID
	    	   public void delete(int inputUserId) {
	  	    	 String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	  		        String user = "222003223";
	  		        String password = "222003223";
	  	        String sql = "DELETE FROM player WHERE playeer_id=?";

	  	        try (Connection connection = DriverManager.getConnection(host, user,password);
	  	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	  	            preparedStatement.setInt(1, inputUserId);

	  	            int rowsAffected = preparedStatement.executeUpdate();

	  	            if (rowsAffected > 0) {
	  	                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
	  	            } else {
	  	                JOptionPane.showMessageDialog(null, "No user found with ID: " + inputUserId, "Delete Error", JOptionPane.ERROR_MESSAGE);
	  	            }
	  	        } catch (SQLException e) {
	  	            JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
	  	        }
	  	    }
	  	}

	

