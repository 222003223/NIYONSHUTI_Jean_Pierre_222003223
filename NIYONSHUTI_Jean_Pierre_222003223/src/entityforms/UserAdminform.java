package entityforms;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import entities.User_admins;
public class UserAdminform implements ActionListener{ 

	 
		                  JFrame frame;
					
		                  JLabel id_lb=new JLabel("User_id");
					JLabel lname_lb=new JLabel("last_name");
					JLabel fname_lb=new JLabel("first name");
					JLabel password_lb=new JLabel(" password");
					JLabel email_lb=new JLabel("email");
					JLabel cont_lb=new JLabel("contact");
					JLabel ma_lb=new JLabel("Manager_id");
				  
					  JTextField id_txf=new JTextField();
					JTextField lname_txf=new JTextField();
					JTextField fname_txf=new JTextField();
					JTextField password_txf=new JTextField();
					JTextField email_txf=new JTextField();
					JTextField cont_txf=new JTextField();
					JTextField ma_txf=new JTextField();
				 //Buttons CRUD
					JButton insert_btn=new JButton("Insert");
					JButton Read_btn=new JButton("View");
					JButton update_tbtn=new JButton("Update");
					JButton delete_btn=new JButton("Delete");
					Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
					int w=(int) screensize.getWidth();
					int h=(int) screensize.getHeight();
					public UserAdminform() {
						createForm();
						}
					private <insertbtn, delete_btn> void ActionEvent() {
						insert_btn.addActionListener(this);
						Read_btn.addActionListener(this);
						update_tbtn.addActionListener(this);
						delete_btn.addActionListener(this);
					}
					private void createForm() {
						frame=new JFrame();
						frame.setTitle("USER ADMIN FORM");
						frame.setBounds(10, 10, 700, 400);
						frame.getContentPane().setLayout(null);
						frame.getContentPane().setBackground(Color.LIGHT_GRAY);
						frame.setVisible(true);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setResizable(true);
						setLocationandSize();
					}


					private void setLocationandSize() {
						id_lb.setBounds(10, 10, 100, 30);
						lname_lb.setBounds(10, 50, 100, 30);
						fname_lb.setBounds(10, 90, 100, 30);
						email_lb.setBounds(10, 170, 100, 30);
						password_lb.setBounds(10, 130, 100, 30);
						cont_lb.setBounds(10, 210, 100, 30);
					    ma_lb.setBounds(10, 250, 200, 30);
					    id_txf.setBounds(160, 10, 200, 30);
					    lname_txf.setBounds(160, 50, 200, 30);
					    fname_txf.setBounds(160, 90, 200, 30);
					    email_txf.setBounds(160, 170, 200, 30);
					    password_txf.setBounds(160, 130, 200, 30);
					    cont_txf.setBounds(160, 210, 200, 30);
						ma_txf.setBounds(160, 250, 200, 30);
						 //Buttons CRUD
						insert_btn.setBounds(10,290, 85, 30);
						Read_btn.setBounds(100,290, 85, 30);
						update_tbtn.setBounds(190,290, 85, 30);
						delete_btn.setBounds(280,290, 85, 30);
						setFontforall();
						addcomponentforFrame();
						}
					private void setFontforall() {
						Font font = new Font("Georgia", Font.BOLD, 18);

						id_lb.setFont(font);
						fname_lb.setFont(font);
						lname_lb.setFont(font);
						email_lb.setFont(font);
						password_lb.setFont(font);
						cont_lb.setFont(font);
						ma_lb.setFont(font);
						//text
		                 id_txf.setFont(font);
						fname_txf.setFont(font);
						lname_txf.setFont(font);
						email_txf.setFont(font);
						 password_txf.setFont(font);
						cont_txf.setFont(font);
					   ma_txf.setFont(font);
						//Buttons CRUD
						Font fonti = new Font("Courier New", Font.ITALIC, 12);

						insert_btn.setFont(fonti);
						Read_btn.setFont(fonti);
						update_tbtn.setFont(fonti);
						delete_btn.setFont(fonti);

					}
					private void addcomponentforFrame() {
						frame.add(id_lb);
						frame.add(fname_lb);
						frame.add(lname_lb);
						frame.add(email_lb);
						frame.add(password_lb);
						frame.add(cont_lb);
					    frame.add(ma_lb);
					//text
						frame.add(id_txf);
						frame.add(lname_txf);
						frame.add(fname_txf);
						frame.add(email_txf);
						frame.add( password_txf);
						frame.add(cont_txf);
						frame.add(ma_txf);
						//Buttons CRUD
						frame.add(insert_btn);
						frame.add(Read_btn);
						frame.add(update_tbtn);
						frame.add(delete_btn);
						ActionEvent();
					}
					@Override
				   public void actionPerformed(ActionEvent e) {
						User_admins User_admin=new User_admins();
						if(e.getSource()==insert_btn) {
							User_admin.setLastName(fname_txf.getText());
							User_admin.setFirstName(lname_txf.getText());
							User_admin.setEmail(email_txf.getText());
							User_admin.setContact(cont_txf.getText());
							User_admin.setPassword(password_txf.getText());
							User_admin.setManagerId(ma_txf.getText());
							User_admin.insertData();
						}else if (e.getSource()==Read_btn) {
							int id=Integer.parseInt(id_txf.getText());
							User_admin.readWithId(id);
							id_txf.setText(String.valueOf(User_admin.getUserId()));
							fname_txf.setText(User_admin.getLastName());
							lname_txf.setText(User_admin.getFirstName());
							email_txf.setText(User_admin.getEmail());
							cont_txf.setText(User_admin.getContact());
							password_txf.setText(User_admin.getPassword());
							ma_txf.setText(User_admin.getManagerId());
						    }else if (e.getSource()==update_tbtn) {
							int id=Integer.parseInt(id_txf.getText());
							User_admin.setLastName(lname_txf.getText());
							User_admin.setFirstName(fname_txf.getText());
							User_admin.setEmail(email_txf.getText());
							User_admin.setPassword(password_txf.getText());
							User_admin.setContact(cont_txf.getText());
							User_admin.setManagerId(ma_txf.getText());
							User_admin.update(id);
						}else {
							int id=Integer.parseInt(id_txf.getText());
							User_admin.delete(id);
						}}
					public static void main(String[] args) {
					UserAdminform User_adminForm= new UserAdminform();
					System.out.println(User_adminForm);
					}}

