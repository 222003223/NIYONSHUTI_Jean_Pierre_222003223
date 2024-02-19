package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
@SuppressWarnings("serial")
public class Logininproject extends JFrame implements ActionListener {
	JFrame frame;

	
	JLabel usernamelb=new JLabel("username");
	JLabel  passwordlb=new JLabel("password");
	JTextField  usernametxf=new JTextField ();
	JPasswordField  passwordpsf=new JPasswordField();
	JButton login_btn=new JButton("Login");
	
	public Logininproject() {
		createwindow();
		SetlocationandSize();
		addcomponetToFrame();
		addActionEvent();
	}
private void addActionEvent() {
		
		login_btn.addActionListener(this);}

private void addcomponetToFrame() {
	
	frame.add(usernamelb);
	frame.add(passwordlb);
	frame.add(usernametxf);
	frame.add(passwordpsf);
	frame.add(login_btn);
}
private void SetlocationandSize() {
	usernamelb.setBounds(10, 50, 300, 30);
	passwordlb.setBounds(10, 100, 300, 30);
	usernametxf.setBounds(180, 50, 300, 30);
	passwordpsf.setBounds(180, 100, 300, 30);
	login_btn.setBounds(280,150, 100, 30);
}
private void createwindow() {
	frame=new JFrame();
	frame.setTitle("welcome to login form");
	frame.setForeground(Color.WHITE);
    frame.setFont(new Font("Arial", Font.BOLD, 24));
	frame.setBounds(0,0,550,320);
	frame.getContentPane().setBackground(Color.white);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	
	//Buttons CRUD
			Font fonti = new Font("Courier New",Font.BOLD, 12);
			
			login_btn.setFont(fonti);
			login_btn.setForeground(Color.black);
			login_btn.setBackground(Color.white);
			}
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login_btn) {
            String username = usernametxf.getText();
            String password = new String(passwordpsf.getPassword());

            // Check credentials against database
            if (validateCredentials(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Open the index form
                new index().setVisible(true);
                SwingUtilities.invokeLater(() ->{
                	new MENUFORM(username).setVisible(true);
                });
                dispose(); // Close the login form
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validateCredentials(String username, String password) {
        String url = "jdbc:mysql://localhost/niyonshuti_jean_pierre_fms";
        String user = "222003223";
        String dbPassword = "222003223";
        String query = "SELECT * FROM login WHERE username = ? AND password = ?";
        
        try (Connection connection = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection error", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Logininproject().setVisible(true));
    }
}


