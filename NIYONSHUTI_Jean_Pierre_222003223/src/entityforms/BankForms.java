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
import entities.Banks;
public class BankForms implements ActionListener{ 
JFrame frame;
					JLabel id_lb=new JLabel("bank_id");
					JLabel bname_lb=new JLabel("bank_name");
					JLabel loc_lb=new JLabel("location");
					JLabel web_lb=new JLabel("Website");
					JLabel cont_lb=new JLabel("contact");
					JLabel bacc_lb=new JLabel("bank_account");
					JLabel cl_lb=new JLabel("club_id");
					
					JTextField id_txf=new JTextField();
					JTextField bname_txf=new JTextField();
					JTextField loc_txf=new JTextField();
					JTextField web_txf=new JTextField();
					JTextField cont_txf=new JTextField();
					JTextField bacc_txf=new JTextField();
					JTextField cl_txf=new JTextField();
					//Buttons CRUD
					JButton insert_btn=new JButton("Insert");
					JButton Read_btn=new JButton("View");
					JButton update_tbtn=new JButton("Update");
					JButton delete_btn=new JButton("Delete");
					Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
					int w=(int) screensize.getWidth();
					int h=(int) screensize.getHeight();
					public BankForms() {
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
						frame.setTitle("BANK FORM");
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
						bname_lb.setBounds(10, 50, 100, 30);
						loc_lb.setBounds(10, 90, 100, 30);
						web_lb.setBounds(10, 130, 100, 30);
						cont_lb.setBounds(10, 170, 100, 30);
						bacc_lb.setBounds(10, 210, 100, 30);
						cl_lb.setBounds(10, 250, 100, 30);
					
						
						id_txf.setBounds(160, 10, 130, 30);
						bname_txf.setBounds(160, 50, 130, 30);
						loc_txf.setBounds(160, 90, 130, 30);
						web_txf.setBounds(160, 130, 130, 30);
						cont_txf.setBounds(160, 170, 130, 30);
						bacc_txf.setBounds(160, 210, 130, 30);
						cl_txf.setBounds(160, 250, 130, 30);
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
						bname_lb.setFont(font);
						loc_lb.setFont(font);
						web_lb.setFont(font);
						cont_lb.setFont(font);
						bacc_lb.setFont(font);
						cl_lb.setFont(font);

						id_txf.setFont(font);
						bname_txf.setFont(font);
						loc_txf.setFont(font);
						web_txf.setFont(font);
						cont_txf.setFont(font);
						bacc_txf.setFont(font);
						cl_txf.setFont(font);
						//Buttons CRUD
						Font fonti = new Font("Courier New", Font.BOLD, 12);

						insert_btn.setFont(fonti);
						Read_btn.setFont(fonti);
						update_tbtn.setFont(fonti);
						delete_btn.setFont(fonti);

					}
					private void addcomponentforFrame() {
						frame.add(id_lb);
						frame.add(bname_lb);
						frame.add(loc_lb);
						frame.add(web_lb);
						frame.add(cont_lb);
						frame.add(bacc_lb);
						frame.add(cl_lb);
						//text
						frame.add(id_txf);
						frame.add(loc_txf);
						frame.add(bname_txf);
						frame.add(web_txf);
						frame.add(cont_txf);
						frame.add(bacc_txf);
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
						Banks pl=new Banks();
						if(e.getSource()==insert_btn) {
							//int id=Integer.parseInt(id_txf.getText());
							//pl.setBank_id(id);
							//pl.setBank_id(id_txf.getText());
							pl.setBankName(bname_txf.getText());
							pl.setLocation(loc_txf.getText());
							pl.setWebsite(web_txf.getText());
							pl.setContact(cont_txf.getText());
							pl.setBankAccount(bacc_txf.getText());
							pl.setClubId(cl_txf.getText());
							pl.insertData();
						}else if (e.getSource()==Read_btn) {
							int id=Integer.parseInt(id_txf.getText());
							pl.readWithID(id);
							id_txf.setText(String.valueOf(pl.getBankId()));
							bname_txf.setText(pl.getBankName());
							loc_txf.setText(pl.getLocation());
							web_txf.setText(pl.getWebsite());
							cont_txf.setText(pl.getContact());
							bacc_txf.setText(pl.getBankAccount());
							cl_txf.setText(pl.getClubId());
						    }else if (e.getSource()==update_tbtn) {
							int id=Integer.parseInt(id_txf.getText());
							pl.setBankName(bname_txf.getText());
							pl.setLocation(loc_txf.getText());
							pl.setWebsite(web_txf.getText());
							pl.setContact(cont_txf.getText());
							pl.setBankAccount(bacc_txf.getText());
							pl.setClubId(cl_txf.getText());
							pl.update(id);
						}else {
							int id=Integer.parseInt(id_txf.getText());
							pl.delete(id);
						}}
					public static void main(String[] args) {
						BankForms  bankform= new BankForms();
					System.out.println(bankform);
					}}




