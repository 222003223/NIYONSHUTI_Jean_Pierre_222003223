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

import entities.Clubs;
public class ClubForm implements ActionListener{  
				JFrame frame;
				JLabel id_lb=new JLabel("Club_id");
				JLabel na_lb=new JLabel("Name");
				JLabel city_lb=new JLabel("City");
				JLabel lea_lb=new JLabel("League");
				JLabel st_lb=new JLabel("Stadium_name");
				JLabel le_lb=new JLabel("league_id");
				
				JTextField id_txf=new JTextField();
				JTextField name_txf=new JTextField();
				JTextField lea_txf=new JTextField();
				JTextField city_txf=new JTextField();
				JTextField st_txf=new JTextField();
				JTextField le_txf=new JTextField();
				//Buttons CRUD
				JButton insert_btn=new JButton("Insert");
				JButton Read_btn=new JButton("View");
				JButton update_tbtn=new JButton("Update");
				JButton delete_btn=new JButton("Delete");
				Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
				int w=(int) screensize.getWidth();
				int h=(int) screensize.getHeight();
				public ClubForm() {
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
					frame.setTitle("CLUB FORM");
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
					na_lb.setBounds(10, 50, 100, 30);
					lea_lb.setBounds(10, 90, 100, 30);
					city_lb.setBounds(10, 130, 100, 30);
					st_lb.setBounds(10, 170, 100, 30);
					le_lb.setBounds(10, 210, 100, 30);
				
					
					id_txf.setBounds(160, 10, 130, 30);
					name_txf.setBounds(160, 50, 130, 30);
					lea_txf.setBounds(160, 90, 130, 30);
					city_txf.setBounds(160, 130, 130, 30);
					st_txf.setBounds(160, 170, 130, 30);
					le_txf.setBounds(160, 210, 130, 30);
			  //Buttons CRUD
					insert_btn.setBounds(10,250, 85, 30);
					Read_btn.setBounds(100,250, 85, 30);
					update_tbtn.setBounds(190,250, 85, 30);
					delete_btn.setBounds(280,250, 85, 30);
					setFontforall();
					addcomponentforFrame();
					}
				private void setFontforall() {
					Font font = new Font("Georgia", Font.BOLD, 18);

					id_lb.setFont(font);
					na_lb.setFont(font);
					lea_lb.setFont(font);
					city_lb.setFont(font);
					st_lb.setFont(font);
					le_lb.setFont(font);

					id_txf.setFont(font);
					name_txf.setFont(font);
					lea_txf.setFont(font);
					city_txf.setFont(font);
					st_txf.setFont(font);
					le_txf.setFont(font);
					//Buttons CRUD
					Font fonti = new Font("Courier New", Font.BOLD, 12);

					insert_btn.setFont(fonti);
					Read_btn.setFont(fonti);
					update_tbtn.setFont(fonti);
					delete_btn.setFont(fonti);

				}
				private void addcomponentforFrame() {
					frame.add(id_lb);
					frame.add(na_lb);
					frame.add(lea_lb);
					frame.add(city_lb);
					frame.add(st_lb);
					frame.add(le_lb);
					//text
					frame.add(id_txf);
					frame.add(name_txf);
					frame.add(lea_txf);
					frame.add(city_txf);
					frame.add(st_txf);
					frame.add(le_txf);
					//Buttons CRUD
					frame.add(insert_btn);
					frame.add(Read_btn);
					frame.add(update_tbtn);
					frame.add(delete_btn);
					ActionEvent();
				}
				@Override
			   public void actionPerformed(ActionEvent e) {
					Clubs pl=new Clubs();
					if(e.getSource()==insert_btn) {
						pl.setName(name_txf.getText());
						pl.setCity(city_txf.getText());
						pl.setLeague(lea_txf.getText());
						pl.setStadium_name(st_txf.getText());
						pl.setLeague_id(le_txf.getText());
						pl.insertData();
					}else if (e.getSource()==Read_btn) {
						int id=Integer.parseInt(id_txf.getText());
						pl.readWithID(id);
						id_txf.setText(String.valueOf(pl.getClubs_id()));
						name_txf.setText(pl.getName());
						city_txf.setText(pl.getCity());
						lea_txf.setText(pl.getLeague());
						st_txf.setText(pl.getStadium_name());
						le_txf.setText(pl.getLeague_id());
					    }else if (e.getSource()==update_tbtn) {
						int id=Integer.parseInt(id_txf.getText());
						pl.setName(name_txf.getText());
						pl.setCity(city_txf.getText());
						pl.setLeague(lea_txf.getText());
						pl.setStadium_name(st_txf.getText());
						pl.setLeague_id(le_txf.getText());
						pl.update(id);
					}else {
						int id=Integer.parseInt(id_txf.getText());
						pl.delete(id);
					}}
				public static void main(String[] args) {
					ClubForm  clubForm= new ClubForm();
				System.out.println(clubForm);
				}}

