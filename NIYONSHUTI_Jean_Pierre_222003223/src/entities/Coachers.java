package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
	public class Coachers {
		    private int coacher_id;
		    private String last_name;
		    private String first_name;
		    private String nationality;
		    private String email;
		    private String contact;
		    private String club_id;

		    public Coachers() {}

		    public Coachers(int coacher_id, String last_name, String first_name, String nationality, String email, String contact, String club_id) {
		        this.coacher_id = coacher_id;
		        this.last_name = last_name;
		        this.first_name = first_name;
		        this.nationality = nationality;
		        this.email = email;
		        this.contact = contact;
		        this.club_id = club_id;
		    }

		    public Coachers(String last_name, String first_name, String nationality, String email, String contact, String club_id) {
		        this.last_name = last_name;
		        this.first_name = first_name;
		        this.nationality = nationality;
		        this.email = email;
		        this.contact = contact;
		        this.club_id = club_id;
		    }

		    public int getCoacher_id() {
		        return coacher_id;
		    }

		    public void setCoacher_id(int coacher_id) {
		        this.coacher_id = coacher_id;
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

		    public String getNationality() {
		        return nationality;
		    }

		    public void setNationality(String nationality) {
		        this.nationality = nationality;
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

		    public String getClub_id() {
		        return club_id;
		    }

		    public void setClub_id(String club_id) {
		        this.club_id = club_id;
		    }
		   
		    private Connection getConnection() throws SQLException {
		        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
		        String user = "222003223";
		        String password = "222003223";
		        return DriverManager.getConnection(url, user, password);
		    }
		    public void insertData() {
		    //public void insertData(String last_name, String first_name, String nationality, String email, String contact, String club_id) {
		        String sql = "INSERT INTO coacher(last_name, first_name, nationality, email, contact, club_id) VALUES (?, ?, ?, ?, ?, ?)";

		        try (Connection con = getConnection();
		             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

		            preparedStatement.setString(1, last_name);
		            preparedStatement.setString(2, first_name);
		            preparedStatement.setString(3, nationality);
		            preparedStatement.setString(4, email);
		            preparedStatement.setString(5, contact);
		            preparedStatement.setString(6, club_id);

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
		            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }

		    public void readWithID(int inputId) {
		        String sql = "SELECT * FROM coacher WHERE coacher_id = ?";

		        try (Connection con = getConnection();
		             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

		            preparedStatement.setInt(1, inputId);
		            ResultSet resultSet = preparedStatement.executeQuery();

		            if (resultSet.next()) {
		                this.setCoacher_id(resultSet.getInt("coacher_id"));
		                this.setLast_name(resultSet.getString("last_name"));
		                this.setFirst_name(resultSet.getString("first_name"));
		                this.setNationality(resultSet.getString("nationality"));
		                this.setEmail(resultSet.getString("email"));
		                this.setContact(resultSet.getString("contact"));
		                this.setClub_id(resultSet.getString("club_id"));
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }

		    public void update(int inputCoacher_id) {
		        String sql = "UPDATE coacher SET last_name = ?, first_name = ?, nationality = ?, email = ?, contact = ?, club_id = ? WHERE coacher_id = ?";

		        try (Connection con = getConnection();
		             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

		            preparedStatement.setString(1, this.getLast_name());
		            preparedStatement.setString(2, this.getFirst_name());
		            preparedStatement.setString(3, this.getNationality());
		            preparedStatement.setString(4, this.getEmail());
		            preparedStatement.setString(5, this.getContact());
		            preparedStatement.setString(6, this.getClub_id());
		            preparedStatement.setInt(7, inputCoacher_id);

		            int rowsAffected = preparedStatement.executeUpdate();

		            if (rowsAffected > 0) {
		                System.out.println("Data updated successfully!");
		            } else {
		                System.out.println("Failed to update data. No matching record found.");
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }

		    public void delete(int inputid) {
		        String sql = "DELETE FROM coacher WHERE coacher_id = ?";

		        try (Connection con = getConnection();
		             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

		            preparedStatement.setInt(1, inputid);
		            int rowsAffected = preparedStatement.executeUpdate();

		            if (rowsAffected > 0) {
		                System.out.println("Data deleted successfully!");
		            } else {
		                System.out.println("Failed to delete data. No matching record found.");
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		}


