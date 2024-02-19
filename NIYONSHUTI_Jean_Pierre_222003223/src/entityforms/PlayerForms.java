package entityforms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entities.Player;
public class PlayerForms implements ActionListener {

    JFrame frame;
    JLabel id_lb = new JLabel("player_id");
    JLabel lname_lb = new JLabel("last_name");
    JLabel fname_lb = new JLabel("first name");
    JLabel email_lb = new JLabel("email");
    JLabel cont_lb = new JLabel("contact");
    JLabel po_lb = new JLabel("position");
    JLabel cl_lb = new JLabel("club_id");
    JLabel co_lb = new JLabel("country");
    JLabel dob_lb = new JLabel("date_of_birth");

    JTextField id_txf = new JTextField();
    JTextField lname_txf = new JTextField();
    JTextField fname_txf = new JTextField();
    JTextField email_txf = new JTextField();
    JTextField cont_txf = new JTextField();
    JTextField cl_txf = new JTextField();
    JTextField co_txf = new JTextField();
    JTextField dob_txf = new JTextField();

    String[] position = { "defender", "Midfielder", "forward", "goalkeeper" };
    JComboBox<String> positionBox = new JComboBox<>(position);

    JButton insert_btn = new JButton("Insert");
    JButton Read_btn = new JButton("View");
    JButton update_btn = new JButton("Update");
    JButton delete_btn = new JButton("Delete");

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getHeight();

    public PlayerForms() {
        createForm();
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("PLAYER_FORM");
        frame.setBounds(10, 10, 500, 600);
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
        email_lb.setBounds(10, 130, 100, 30);
        cont_lb.setBounds(10, 170, 100, 30);
        po_lb.setBounds(10, 210, 100, 30);
        cl_lb.setBounds(10, 250, 100, 30);
        co_lb.setBounds(10, 290, 100, 30);
        dob_lb.setBounds(10, 330, 100, 30);

        id_txf.setBounds(160, 10, 130, 30);
        fname_txf.setBounds(160, 50, 130, 30);
        lname_txf.setBounds(160, 90, 130, 30);
        email_txf.setBounds(160, 130, 130, 30);
        cont_txf.setBounds(160, 170, 130, 30);
        positionBox.setBounds(160, 210, 130, 30);
        cl_txf.setBounds(160, 250, 130, 30);
        co_txf.setBounds(160, 290, 130, 30);
        dob_txf.setBounds(160, 330, 130, 30);

        insert_btn.setBounds(10, 370, 85, 30);
        Read_btn.setBounds(100, 370, 85, 30);
        update_btn.setBounds(190, 370, 85, 30);
        delete_btn.setBounds(280, 370, 85, 30);

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
        po_lb.setFont(font);
        co_lb.setFont(font);
        cl_lb.setFont(font);
        dob_lb.setFont(font);

        id_txf.setFont(font);
        fname_txf.setFont(font);
        lname_txf.setFont(font);
        email_txf.setFont(font);
        cont_txf.setFont(font);
        positionBox.setFont(font);
        cl_txf.setFont(font);
        co_txf.setFont(font);
        dob_txf.setFont(font);

        Font fonti = new Font("Courier New", Font.ITALIC, 12);

        insert_btn.setFont(fonti);
        Read_btn.setFont(fonti);
        update_btn.setFont(fonti);
        delete_btn.setFont(fonti);
    }

    private void addcomponentforFrame() {
        frame.add(id_lb);
        frame.add(fname_lb);
        frame.add(lname_lb);
        frame.add(email_lb);
        frame.add(cont_lb);
        frame.add(po_lb);
        frame.add(cl_lb);
        frame.add(co_lb);
        frame.add(dob_lb);

        frame.add(id_txf);
        frame.add(lname_txf);
        frame.add(fname_txf);
        frame.add(email_txf);
        frame.add(cont_txf);
        frame.add(positionBox);
        frame.add(cl_txf);
        frame.add(co_txf);
        frame.add(dob_txf);

        frame.add(insert_btn);
        frame.add(Read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);

        insert_btn.addActionListener(this);
        Read_btn.addActionListener(this);
        update_btn.addActionListener(this);
        delete_btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player pl= new Player();
        if (e.getSource() == insert_btn) {
            pl.setLast_name(fname_txf.getText());
            pl.setFirst_name(lname_txf.getText());
            pl.setEmail(email_txf.getText());
            pl.setContact(cont_txf.getText());
            pl.setPosition((String) positionBox.getSelectedItem());
            // You may need to convert club_id to int if it's not a String
            pl.setClub_id(Integer.parseInt(cl_txf.getText()));
            pl.setCountry(co_txf.getText());
            pl.setDate_of_birth(dob_txf.getText());
            pl.insertData();
        } else if (e.getSource() == Read_btn) {
            int id = Integer.parseInt(id_txf.getText());
            pl.readWithID(id);
            id_txf.setText(String.valueOf(pl.getPlayer_id()));
            fname_txf.setText(pl.getLast_name());
            lname_txf.setText(pl.getFirst_name());
            email_txf.setText(pl.getEmail());
            cont_txf.setText(pl.getContact());
            positionBox.setSelectedItem(pl.getPosition());
            cl_txf.setText(String.valueOf(pl.getClub_id()));
            co_txf.setText(pl.getCountry());
            dob_txf.setText(pl.getDate_of_birth());
        } else if (e.getSource() == update_btn) {
            int id = Integer.parseInt(id_txf.getText());
            pl.setLast_name(fname_txf.getText());
            pl.setFirst_name(lname_txf.getText());
            pl.setEmail(email_txf.getText());
            pl.setContact(cont_txf.getText());
            pl.setPosition((String) positionBox.getSelectedItem());
            // You may need to convert club_id to int if it's not a String
            pl.setClub_id(Integer.parseInt(cl_txf.getText()));
            pl.setCountry(co_txf.getText());
            pl.setDate_of_birth(dob_txf.getText());
            pl.update(id);
        } else if (e.getSource() == delete_btn) {
            int id = Integer.parseInt(id_txf.getText());
            pl.delete(id);
        }
    }

    public static void main(String[] args) {
        PlayerForms plform = new PlayerForms();
        System.out.println(plform);
    }
}
