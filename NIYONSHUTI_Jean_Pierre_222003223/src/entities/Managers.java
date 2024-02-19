package entities;
import javax.swing.JOptionPane;
import java.sql.*;
public class Managers {
	    private int manager_id;
	    private String last_name;
	    private String first_name;
	    private String email;
	    private String contact;
	    private String club_id;

	    public Managers() {}

	    public Managers(int manager_id, String last_name, String first_name, String email, String contact, String club_id) {
	        this.manager_id = manager_id;
	        this.last_name = last_name;
	        this.first_name = first_name;
	        this.email = email;
	        this.contact = contact;
	        this.club_id = club_id;
	    }

	    public Managers(String lname, String fname, String email, String contact, String club_id) {
	        this.last_name = lname;
	        this.first_name = fname;
	        this.email = email;
	        this.contact = contact;
	        this.club_id = club_id;
	    }

	    public int getManager_id() {
			return manager_id;
		}

		public void setManager_id(int manager_id) {
			this.manager_id = manager_id;
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

		public String getClub_id() {
			return club_id;
		}

		public void setClub_id(String club_id) {
			this.club_id = club_id;
		}

		public void insertData() {
	        String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	        String user = "222003223";
	        String password = "222003223";
	        String sql = "INSERT INTO manager (last_name, first_name, email, contact, club_id) VALUES (?, ?, ?, ?, ?)";
	        try (Connection con = DriverManager.getConnection(host, user, password);
	             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setString(1, last_name);
	            preparedStatement.setString(2, first_name);
	            preparedStatement.setString(3, email);
	            preparedStatement.setString(4, contact);
	            preparedStatement.setString(5, club_id);

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
	        }
	    }

	    public void readWithID(int inputId) {
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223_fms";
	        String user = "222003223";
	        String password = "222003223";
	        String sql = "SELECT * FROM manager WHERE manager_id = ?";
	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, inputId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                manager_id = resultSet.getInt("manager_id");
	                last_name = resultSet.getString("last_name");
	                first_name = resultSet.getString("first_name");
	                email = resultSet.getString("email");
	                contact = resultSet.getString("contact");
	                club_id = resultSet.getString("club_id");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void update(int inputManagerId) {
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223_fms";
	        String user = "222003223";
	        String password = "";
	        String sql = "UPDATE manager SET last_name = ?, first_name = ?, email = ?, contact = ?, club_id = ? WHERE manager_id = ?";
	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, last_name);
	            preparedStatement.setString(2, first_name);
	            preparedStatement.setString(3, email);
	            preparedStatement.setString(4, contact);
	            preparedStatement.setString(5, club_id);
	            preparedStatement.setInt(6, inputManagerId);
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
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223_fms";
	        String user = "222003223";
	        String password = "222003223";
	        String sql = "DELETE FROM manager WHERE manager_id = ?";
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

