package menu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entities.User_admins;


public class Admin_SignUp  extends JFrame{
	
    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fnametext;
	private JTextField lnametext;
	private JTextField phonetext;
	private JTextField usrnmtxt;
	private JTextField emailtext;
	private JPasswordField passwordtext;
	

	/**
	 * Launch the application.
	 */

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			Admin_SignUp frame = new Admin_SignUp();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});
}

/**
* Create the frame.
*/
public Admin_SignUp() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 633, 505);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblfnmae = new JLabel("FIRST NAME :");
lblfnmae.setBounds(10, 77, 85, 23);
contentPane.add(lblfnmae);

JLabel lbllname = new JLabel("LAST NAME :");
lbllname.setBounds(10, 124, 85, 23);
contentPane.add(lbllname);

fnametext = new JTextField();
fnametext.setBounds(97, 73, 180, 33);
contentPane.add(fnametext);
fnametext.setColumns(10);

lnametext = new JTextField();
lnametext.setBounds(97, 123, 180, 33);
lnametext.setColumns(10);
contentPane.add(lnametext);

JLabel lblPhone = new JLabel("Phone :");
lblPhone.setBounds(10, 183, 77, 23);
contentPane.add(lblPhone);
//fname, lname, phone,email, username, password
phonetext = new JTextField();
phonetext.setBounds(97, 179, 180, 33);
phonetext.setColumns(10);
contentPane.add(phonetext);

JLabel lblEmail = new JLabel("Email :");
lblEmail.setBounds(348, 124, 77, 23);
contentPane.add(lblEmail);

emailtext = new JTextField();
emailtext.setBounds(425, 123, 180, 33);
emailtext.setColumns(10);
contentPane.add(emailtext);

JLabel lblDateOfBirth = new JLabel("ManagerID :");
lblDateOfBirth.setBounds(348, 77, 77, 23);
contentPane.add(lblDateOfBirth);

usrnmtxt = new JTextField();
usrnmtxt.setBounds(425, 73, 180, 33);
usrnmtxt.setColumns(10);
contentPane.add(usrnmtxt);

JLabel lblPhone_1_1 = new JLabel("Password :");
lblPhone_1_1.setBounds(348, 183, 77, 23);
contentPane.add(lblPhone_1_1);

passwordtext = new JPasswordField();
passwordtext.setBounds(423, 179, 182, 33);
contentPane.add(passwordtext);

JButton btnNewButton = new JButton("CANCEL");
btnNewButton.setBounds(209, 285, 126, 33);
contentPane.add(btnNewButton);

JButton signUp = new JButton("SIGN UP");
signUp.setBounds(380, 285, 132, 33);
signUp.addActionListener(new ActionListener() {
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		LOGIN_ADMINFORM frame = new LOGIN_ADMINFORM();
		frame.setVisible(true);
		User_admins ad = new User_admins();
		if(e.getSource()==signUp) {
			ad.setFirstName(fnametext.getText());
			ad.setLastName(lnametext.getText());
			ad.setPassword(passwordtext.getText());
			ad.setContact(phonetext.getText());
			ad.setManagerId(usrnmtxt.getText());
			ad.setEmail(emailtext.getText());
			char[] passwordChars = passwordtext.getPassword();
			String passwordString = new String(passwordChars);
			ad.setPassword(passwordString);
			ad.insertData();
			System.out.print(ad.getFirstName() + " " + ad.getLastName() + " "  + " " + ad.getPassword() + " " + " " +ad.getEmail() + " " +  ad.getManagerId() + " " + ad.getContact() );
		}
	}
});
contentPane.add(signUp);
}

}


