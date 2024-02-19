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

import entities.Leagues;
public class Leagueforms implements ActionListener{  
			                  JFrame frame;
						//User_id;league_name;first_name;email;contact; password;Manager_id;country;date_of_birth; match_id;
						
						JLabel llid_lb=new JLabel("league_id");
						JLabel lname_lb=new JLabel("league_name");
						JLabel cou_lb=new JLabel("country");
						JLabel se_lb=new JLabel("season");
						JLabel end_lb=new JLabel("end_date");
						JLabel start_lb=new JLabel("start_date");
				          JLabel number_lb=new JLabel("number_club");
					  
						JTextField lid_txf=new JTextField();
						JTextField lname_txf=new JTextField();
						JTextField cou_txf=new JTextField();
						JTextField se_txf=new JTextField();
						JTextField start_txf=new JTextField();
						  JTextField end_txfend=new JTextField();
					JTextField number_txf=new JTextField();
					 //Buttons CRUD
						JButton insert_btn=new JButton("Insert");
						JButton Read_btn=new JButton("View");
						JButton update_tbtn=new JButton("Update");
						JButton delete_btn=new JButton("Delete");
						Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
						int w=(int) screensize.getWidth();
						int h=(int) screensize.getHeight();
						public Leagueforms() {
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
							frame.setTitle("LEAGUE FORM");
							frame.setBounds(10, 10, 700, 400);
							frame.getContentPane().setLayout(null);
							frame.getContentPane().setBackground(Color.LIGHT_GRAY);
							frame.setVisible(true);
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame.setResizable(true);
							setLocationandSize();
						}


						private void setLocationandSize() {
							llid_lb.setBounds(10, 10, 100, 30);
							lname_lb.setBounds(10, 50, 100, 30);
							cou_lb.setBounds(10, 90, 100, 30);
							se_lb.setBounds(10, 170, 100, 30);
							start_lb.setBounds(10, 130, 100, 30);
							end_lb.setBounds(10, 210, 100, 30);
						    number_lb.setBounds(10, 250, 200, 30);
						    lid_txf.setBounds(160, 10, 200, 30);
						    lname_txf.setBounds(160, 50, 200, 30);
						    cou_txf.setBounds(160, 90, 200, 30);
						    se_txf.setBounds(160, 170, 200, 30);
						    start_txf.setBounds(160, 130, 200, 30);
						    end_txfend.setBounds(160, 210, 200, 30);
						number_txf.setBounds(160, 250, 200, 30);
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

							llid_lb.setFont(font);
							lname_lb.setFont(font);
							cou_lb.setFont(font);
							se_lb.setFont(font);
							start_lb.setFont(font);
							end_lb.setFont(font);
							number_lb.setFont(font);
							//text
			                 lid_txf.setFont(font);
							lname_txf.setFont(font);
							lname_txf.setFont(font);
							se_txf.setFont(font);
							 start_txf.setFont(font);
							end_txfend.setFont(font);
						   number_txf.setFont(font);
							//Buttons CRUD
							Font fonti = new Font("Courier New", Font.ITALIC, 12);

							insert_btn.setFont(fonti);
							Read_btn.setFont(fonti);
							update_tbtn.setFont(fonti);
							delete_btn.setFont(fonti);

						}
						private void addcomponentforFrame() {
							frame.add(llid_lb);
							frame.add(lname_lb);
							frame.add(cou_lb);
							frame.add(se_lb);
							frame.add(start_lb);
							frame.add(end_lb);
						    frame.add(number_lb);
						//text
							frame.add(lid_txf);
							frame.add(lname_txf);
							frame.add(cou_txf);
							frame.add(se_txf);
							frame.add( start_txf);
							frame.add(end_txfend);
							frame.add(number_txf);
							//Buttons CRUD
							frame.add(insert_btn);
							frame.add(Read_btn);
							frame.add(update_tbtn);
							frame.add(delete_btn);
							ActionEvent();
						}
						@Override
					   public void actionPerformed(ActionEvent e) {
							Leagues league=new Leagues();
							if(e.getSource()==insert_btn) {
								league.setLeague_name(lname_txf.getText());
								league.setCountry(cou_txf.getText());
								league.setSeason(se_txf.getText());
								league.setStart_date(start_txf.getText());
								league.setEnd_date(end_txfend.getText());
								league.setNumber_club(number_txf.getText());
								league.insertData();
							}else if (e.getSource()==Read_btn) {
								int id=Integer.parseInt(lid_txf.getText());
								league.readWithID(id);
								lid_txf.setText(String.valueOf(league.getLeague_id()));
								lname_txf.setText(league.getLeague_name());
								cou_txf.setText(league.getCountry());
								se_txf.setText(league.getSeason());
								start_txf.setText(league.getStart_date());
								end_txfend.setText(league.getEnd_date());
								number_txf.setText(league.getNumber_club());
							    }else if (e.getSource()==update_tbtn) {
								int id=Integer.parseInt(lid_txf.getText());
								league.setLeague_name(lname_txf.getText());
								league.setCountry(cou_txf.getText());
								league.setSeason(se_txf.getText());
								league.setEnd_date(start_txf.getText());
								league.setEnd_date(end_txfend.getText());
								league.setNumber_club(number_txf.getText());
								league.update(id);
							}else {
								int id=Integer.parseInt(lid_txf.getText());
								league.delete(id);
							}}
						public static void main(String[] args) {
							Leagueforms leagueForm= new Leagueforms();
						System.out.println(leagueForm);
						}}

