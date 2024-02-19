package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Banks {
  private int bankId;
	    private String bankName;
	    private String location;
	    private String website;
	    private String contact;
	    private String bankAccount;
	    private String clubId;

	    // Constructors, getters, and setters

	    public Banks() {}

	    public Banks(int bankId, String bankName, String location, String website, String contact, String bankAccount, String clubId) {
	        this.bankId = bankId;
	        this.bankName = bankName;
	        this.location = location;
	        this.website = website;
	        this.contact = contact;
	        this.bankAccount = bankAccount;
	        this.clubId = clubId;
	    }

	    // Getters and setters

	    public int getBankId() {
	        return bankId;
	    }

	    public void setBankId(int bankId) {
	        this.bankId = bankId;
	    }

	    public String getBankName() {
	        return bankName;
	    }

	    public void setBankName(String bankName) {
	        this.bankName = bankName;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public String getWebsite() {
	        return website;
	    }

	    public void setWebsite(String website) {
	        this.website = website;
	    }

	    public String getContact() {
	        return contact;
	    }

	    public void setContact(String contact) {
	        this.contact = contact;
	    }

	    public String getBankAccount() {
	        return bankAccount;
	    }

	    public void setBankAccount(String bankAccount) {
	        this.bankAccount = bankAccount;
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

	        String sql = "INSERT INTO bank (bank_name, location, website, contact, bank_account, club_id) VALUES (?, ?, ?, ?, ?, ?)";

	        try (Connection con = DriverManager.getConnection(host, user, password);
	             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setString(1, bankName);
	            preparedStatement.setString(2, location);
	            preparedStatement.setString(3, website);
	            preparedStatement.setString(4, contact);
	            preparedStatement.setString(5, bankAccount);
	            preparedStatement.setString(6, clubId);

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

	        String sql = "SELECT * FROM bank WHERE bank_id = ?";

	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, inputId);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                this.setBankId(resultSet.getInt("bank_id"));
	                this.setBankName(resultSet.getString("bank_name"));
	                this.setLocation(resultSet.getString("location"));
	                this.setWebsite(resultSet.getString("website"));
	                this.setContact(resultSet.getString("contact"));
	                this.setBankAccount(resultSet.getString("bank_account"));
	                this.setClubId(resultSet.getString("club_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void update(int inputBankId) {
	        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
	        String user = "222003223";
	        String password = "222003223";

	        String sql = "UPDATE bank SET bank_name = ?, location = ?, website = ?, contact = ?, bank_account = ?, club_id = ? WHERE bank_id = ?";

	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, this.getBankName());
	            preparedStatement.setString(2, this.getLocation());
	            preparedStatement.setString(3, this.getWebsite());
	            preparedStatement.setString(4, this.getContact());
	            preparedStatement.setString(5, this.getBankAccount());
	            preparedStatement.setString(6, this.getClubId());
	            preparedStatement.setInt(7, inputBankId);

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

	        String sql = "DELETE FROM bank WHERE bank_id = ?";

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
