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

import entities.Stadium;
public class Stadiumforms implements ActionListener{ 
JFrame frame;
					JLabel id_lb=new JLabel("studium_id");
					JLabel sname_lb=new JLabel("studium_name");
					JLabel ca_lb=new JLabel("capacity");
					JLabel cl_lb=new JLabel("club_id");
					
					JTextField id_txf=new JTextField();
					JTextField name_txf=new JTextField();
					JTextField capacity_txf=new JTextField();
					JTextField cl_txf=new JTextField();
					//Buttons CRUD
					JButton insert_btn=new JButton("Insert");
					JButton Read_btn=new JButton("View");
					JButton update_tbtn=new JButton("Update");
					JButton delete_btn=new JButton("Delete");
					Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
					int w=(int) screensize.getWidth();
					int h=(int) screensize.getHeight();
					public Stadiumforms() {
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
						frame.setTitle("STADIUMFORM");
						frame.setBounds(10, 10, 700, 300);
						frame.getContentPane().setLayout(null);
						frame.getContentPane().setBackground(Color.LIGHT_GRAY);
						frame.setVisible(true);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setResizable(true);
						setLocationandSize();
					}


					private void setLocationandSize() {
						id_lb.setBounds(10, 10, 100, 30);
						sname_lb.setBounds(10, 50, 100, 30);
						ca_lb.setBounds(10, 90, 100, 30);
						cl_lb.setBounds(10, 130, 100, 30);
					
						
						id_txf.setBounds(160, 10, 130, 30);
						name_txf.setBounds(160, 50, 130, 30);
						capacity_txf.setBounds(160, 90, 130, 30);
						cl_txf.setBounds(160, 130, 130, 30);
				  //Buttons CRUD
						insert_btn.setBounds(10,170, 85, 30);
						Read_btn.setBounds(100,170, 85, 30);
						update_tbtn.setBounds(190,170, 85, 30);
						delete_btn.setBounds(280,170, 85, 30);
						setFontforall();
						addcomponentforFrame();
						}
					private void setFontforall() {
					Font font = new Font("Georgia", Font.BOLD, 18);

						id_lb.setFont(font);
						sname_lb.setFont(font);
						ca_lb.setFont(font);
						capacity_txf.setFont(font);
						cl_lb.setFont(font);

						id_txf.setFont(font);
						name_txf.setFont(font);
						capacity_txf.setFont(font);
						cl_txf.setFont(font);
						//Buttons CRUD
						Font fonti = new Font("Courier New", Font.ITALIC, 12);

						insert_btn.setFont(fonti);
						Read_btn.setFont(fonti);
						update_tbtn.setFont(fonti);
						delete_btn.setFont(fonti);

					}
					private void addcomponentforFrame() {
						frame.add(id_lb);
						frame.add(sname_lb);
						frame.add(ca_lb);
						frame.add(cl_lb);
						//text
						frame.add(id_txf);
						frame.add(name_txf);
						frame.add(capacity_txf);
						frame.add(cl_txf);
						//Buttons CRUD
						frame.add(insert_btn);
						frame.add(Read_btn);
						frame.add(update_tbtn);
						frame.add(delete_btn);
						ActionEvent();
					}
					@Override
				   public void actionPerformed(ActionEvent e) {
						Stadium std=new Stadium();
						if(e.getSource()==insert_btn) {
							std.setStudiumName(name_txf.getText());
							std.setCapacity(capacity_txf.getText());
							std.setClubId(cl_txf.getText());
							std.insertData();
						}else if (e.getSource()==Read_btn) {
							int id=Integer.parseInt(id_txf.getText());
							std.readWithID(id);
							id_txf.setText(String.valueOf(std.getStudiumId()));
							name_txf.setText(std.getStudiumName());
							capacity_txf.setText(std.getCapacity());
							cl_txf.setText(std.getClubId());
						    }else if (e.getSource()==update_tbtn) {
							int id=Integer.parseInt(id_txf.getText());
							std.setStudiumName(name_txf.getText());
							std.setCapacity(capacity_txf.getText());
							std.setClubId(cl_txf.getText());
							std.update(id);
						}else {
							int id=Integer.parseInt(id_txf.getText());
							
							std.delete(id);
						}}
					public static void main(String[] args) {
					Stadiumforms  stadiumForm= new Stadiumforms();
					System.out.println(stadiumForm);
					}}



