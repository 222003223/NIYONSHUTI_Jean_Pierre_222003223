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

import entities.Coachers;
public class CoacherForm implements ActionListener{ 
                  JFrame frame;
			
			JLabel id_lb=new JLabel("coacher_id");
			JLabel lname_lb=new JLabel("last_name");
			JLabel fname_lb=new JLabel("first name");
			JLabel nationality_lb=new JLabel(" nationality");
			JLabel email_lb=new JLabel("email");
			JLabel cont_lb=new JLabel("contact");
	          JLabel cl_lb=new JLabel("club_id");
		    JTextField id_txf=new JTextField();
			JTextField lname_txf=new JTextField();
			JTextField fname_txf=new JTextField();
			JTextField nationality_txf=new JTextField();
			JTextField email_txf=new JTextField();
			JTextField cont_txf=new JTextField();
		JTextField cl_txf=new JTextField();
		 //Buttons CRUD
			JButton insert_btn=new JButton("Insert");
			JButton Read_btn=new JButton("View");
			JButton update_tbtn=new JButton("Update");
			JButton delete_btn=new JButton("Delete");
			Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
			int w=(int) screensize.getWidth();
			int h=(int) screensize.getHeight();
			public CoacherForm() {
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
				frame.setTitle("Coacher form");
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
				fname_lb.setBounds(10, 50, 100, 30);
				lname_lb.setBounds(10, 90, 100, 30);
				nationality_lb.setBounds(10, 130, 100, 30);
				email_lb.setBounds(10, 170, 100, 30);
				cont_lb.setBounds(10, 210, 100, 30);
			    cl_lb.setBounds(10, 250, 100, 30);
			   id_txf.setBounds(160, 10, 130, 30);
				fname_txf.setBounds(160, 50, 130, 30);
				lname_txf.setBounds(160, 90, 130, 30);
				 nationality_txf.setBounds(160, 130, 130, 30);
				email_txf.setBounds(160, 170, 130, 30);
				cont_txf.setBounds(160, 210, 130, 30);
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
				fname_lb.setFont(font);
				lname_lb.setFont(font);
				email_lb.setFont(font);
				cont_lb.setFont(font);
				nationality_lb.setFont(font);
				cl_lb.setFont(font);
				//text
                 id_txf.setFont(font);
				fname_txf.setFont(font);
				lname_txf.setFont(font);
				email_txf.setFont(font);
				cont_txf.setFont(font);
				 nationality_txf.setFont(font);
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
				frame.add(fname_lb);
				frame.add(lname_lb);
				frame.add(email_lb);
				frame.add(cont_lb);
				frame.add(nationality_lb);
				frame.add(cl_lb);
			//text
				frame.add(id_txf);
				frame.add(lname_txf);
				frame.add(fname_txf);
				frame.add(email_txf);
				frame.add(cont_txf);
				frame.add( nationality_txf);
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
				Coachers coacher=new Coachers();
				if(e.getSource()==insert_btn) {
					coacher.setLast_name(fname_txf.getText());
					coacher.setFirst_name(lname_txf.getText());
					coacher.setNationality(nationality_txf.getText());
					coacher.setEmail(email_txf.getText());
					coacher.setContact(cont_txf.getText());
					coacher.setClub_id(cl_txf.getText());
					coacher.insertData();
				}else if (e.getSource()==Read_btn) {
					int id=Integer.parseInt(id_txf.getText());
					//int id2=Integer.parseInt(cl_txf.getText());
					coacher.readWithID(id);
					//coacher.readwithID(id2);
					id_txf.setText(String.valueOf(coacher.getCoacher_id()));
					fname_txf.setText(coacher.getLast_name());
					lname_txf.setText(coacher.getFirst_name());
					email_txf.setText(coacher.getEmail());
					cont_txf.setText(coacher.getContact());
					nationality_txf.setText(coacher.getNationality());
					//cl_txf.setText(coacher.getClub_id());
				    }else if (e.getSource()==update_tbtn) {
					int id=Integer.parseInt(id_txf.getText());
					coacher.setLast_name(fname_txf.getText());
					coacher.setFirst_name(lname_txf.getText());
					coacher.setNationality(nationality_txf.getText());
					coacher.setEmail(email_txf.getText());
					coacher.setContact(cont_txf.getText());
					coacher.setClub_id(cl_txf.getText());
				coacher.update(id);
				}else {
					int id=Integer.parseInt(id_txf.getText());
					coacher.delete(id);
				}}
			public static void main(String[] args) {
			CoacherForm coacherForm= new CoacherForm();
			System.out.println(coacherForm);
			}}

