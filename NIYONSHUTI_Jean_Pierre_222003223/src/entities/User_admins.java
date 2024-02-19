package entities;

import javax.swing.JOptionPane;
import java.sql.*;
public class User_admins {
	    private int userId;
	    private String lastName;
	    private String firstName;
	    private String password;
	    private String email;
	    private String contact;
	    private String managerId;
		public User_admins() {}
		public User_admins(int User_id, String last_name , String first_name, String  password,String email, String contact ,String Manager_id) {
			this. userId =  User_id;
			this.lastName = last_name;
			this.firstName = first_name;
			this.email = email;
			this.contact = contact;
			this. password= password;
			this.managerId=Manager_id;
			}
		public User_admins( String lname, String fname,String  password,String email, String telephone,String Manager_id) {
			this.lastName = fname;
			this.firstName = lname;
			this.email = email;
			this.contact= telephone;
			this. password= password;
			this.managerId=Manager_id;
		
		}
		
// Constructors, getters, and setters omitted for brevity
		

	    public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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
		public String getManagerId() {
			return managerId;
		}
		public void setManagerId(String managerId) {
			this.managerId = managerId;
		}
		public void insertData() {
			  String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
		        String user = "222003223";
		        String password = "222003223";
	        String sql = "INSERT INTO User_admin(last_name, first_name, password, email, contact, Manager_id) VALUES (?, ?, ?, ?, ?, ?)";

	        try (Connection connection = DriverManager.getConnection(host, user,password);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, this.lastName);
	            preparedStatement.setString(2, this.firstName);
	            preparedStatement.setString(3, this.password);
	            preparedStatement.setString(4, this.email);
	            preparedStatement.setString(5, this.contact);
	            preparedStatement.setString(6, this.managerId);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Failed to insert data!", "After insert", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Failed to insert data: " + e.getMessage(), "After insert", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public void readWithId(int inputId) {
	    	 String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223_fms";
		        String user = "222003223";
		        String password = "222003223";
	        String sql = "SELECT * FROM User_admin WHERE User_id = ?";

	        try (Connection connection = DriverManager.getConnection(host, user,password);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, inputId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                this.lastName = resultSet.getString("last_name");
	                this.firstName = resultSet.getString("first_name");
	                this.email = resultSet.getString("email");
	                this.password = resultSet.getString("password");
	                this.contact = resultSet.getString("contact");
	                this.userId = resultSet.getInt("User_id");
	                this.managerId = resultSet.getString("Manager_id");
	            } else {
	                JOptionPane.showMessageDialog(null, "No user found with ID: " + inputId, "Read Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public void update(int inputUserId) {
	    	 String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223_fms";
		        String user = "222003223";
		        String password = "222003223";
	        String sql = "UPDATE User_admin SET last_name=?, first_name=?, email=?, contact=?, password=?, Manager_id=? WHERE User_id=?";

	        try (Connection connection = DriverManager.getConnection(host, user,password);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, this.lastName);
	            preparedStatement.setString(2, this.firstName);
	            preparedStatement.setString(3, this.email);
	            preparedStatement.setString(4, this.contact);
	            preparedStatement.setString(5, this.password);
	            preparedStatement.setString(6, this.managerId);
	            preparedStatement.setInt(7, inputUserId);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "No user found with ID: " + inputUserId, "Update Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public void delete(int inputUserId) {
	    	 String host = "jdbc:mysql://localhost/niyonshuti_jean_pierre_222003223_fms";
		        String user = "222003223";
		        String password = "222003223";
	        String sql = "DELETE FROM User_admin WHERE User_id=?";

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
	
			     public void login() {
			       
			        if (isValidUser(email, password)) {
			            System.out.println("Login successful");
			        } else {
			            System.out.println("Invalid username or password");
			        }
			    }
			    
			    private boolean isValidUser(String email, String password) {
			        // TODO: Implement your user validation logic here
			        // This could involve checking credentials against a database, file, or other storage
			        
			        // Example validation (replace with your actual logic):
			        return email.equals("admin") && password.equals("password");
			    }
			

			
		}


