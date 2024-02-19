package entities;

import javax.swing.JOptionPane;
import java.sql.*;

public class Leagues {
    private int league_id;
    private String league_name;
    private String country;
    private String season;
    private String start_date;
    private String end_date;
    private String number_club;

    // Constructors
    public Leagues() {}

    public Leagues(int league_id, String league_name, String country, String season, String start_date, String end_date, String number_club) {
        this.league_id = league_id;
        this.league_name = league_name;
        this.country = country;
        this.season = season;
        this.start_date = start_date;
        this.end_date = end_date;
        this.number_club = number_club;
    }

    // Getters and Setters
    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getNumber_club() {
        return number_club;
    }

    public void setNumber_club(String number_club) {
        this.number_club = number_club;
    }

    // Method to establish database connection
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
        String username = "222003223";
        String password = "222003223";
        return DriverManager.getConnection(url, username, password);
    }

    // Insert data into the database
    public void insertData() {
        String sql = "INSERT INTO league (league_name, country, season, start_date, end_date, number_club) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, league_name);
            preparedStatement.setString(2, country);
            preparedStatement.setString(3, season);
            preparedStatement.setString(4, start_date);
            preparedStatement.setString(5, end_date);
            preparedStatement.setString(6, number_club);

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

    // Read data from the database based on league_id
    public void readWithID(int inputId) {
        String sql = "SELECT * FROM league WHERE league_id = ?";
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, inputId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                league_name = resultSet.getString("league_name");
                country = resultSet.getString("country");
                start_date = resultSet.getString("start_date");
                season = resultSet.getString("season");
                end_date = resultSet.getString("end_date");
                league_id = resultSet.getInt("league_id");
                number_club = resultSet.getString("number_club");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update data in the database based on league_id
    public void update(int inputLeagueId) {
        String sql = "UPDATE league SET league_name = ?, country = ?, start_date = ?, end_date = ?, season = ?, number_club = ? WHERE league_id = ?";
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, league_name);
            preparedStatement.setString(2, country);
            preparedStatement.setString(3, start_date);
            preparedStatement.setString(4, end_date);
            preparedStatement.setString(5, season);
            preparedStatement.setString(6, number_club);
            preparedStatement.setInt(7, inputLeagueId);
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

    // Delete data from the database based on league_id
    public void delete(int inputId) {
        String sql = "DELETE FROM league WHERE league_id = ?";
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
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
