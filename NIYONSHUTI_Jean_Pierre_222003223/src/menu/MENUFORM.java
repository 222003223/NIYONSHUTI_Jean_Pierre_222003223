package menu;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import entityforms.BankForms;
import entityforms.ClubForm;
import entityforms.CoacherForm;
import entityforms.Leagueforms;
import entityforms.Managerforms;
import entityforms.PlayerForms;
import entityforms.Stadiumforms;
import entityforms.UserAdminform;

public class MENUFORM extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu PlayerMenu;
    private JMenu User_adminMenu;
    private JMenu ManagersMenu;
    private JMenu CoacherMenu;
    private JMenu ClubMenu;
    private JMenu BankMenu;
    private JMenu leagueMenu;
    private JMenu stadiuMenu;
    private JMenu logoutMenu;

    private JMenuItem PlayerItem;
    private JMenuItem User_adminItem;
    private JMenuItem ManagersItem;
    private JMenuItem CoacherItem;
    private JMenuItem ClubItem;
    private JMenuItem BankItem;
    private JMenuItem  leaguItem;
    private JMenuItem stadiuItem;
    private JMenuItem logoutItem;

    private String loggedInUser;

    public MENUFORM(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create menu items
        PlayerMenu = new JMenu("PLAYER");
        PlayerItem = new JMenuItem("Player Form");
        PlayerItem.addActionListener(this);

        User_adminMenu = new JMenu("USER ADMIN");
        User_adminItem = new JMenuItem("User_admin Form");
        User_adminItem.addActionListener(this);

        ManagersMenu = new JMenu("MANAGER");
        ManagersItem = new JMenuItem("Manager Form");
        ManagersItem.addActionListener(this);

        CoacherMenu = new JMenu("COACHER");
        CoacherItem = new JMenuItem("Coacher Form");
        CoacherItem.addActionListener(this);

        ClubMenu = new JMenu("CLUB");
        ClubItem = new JMenuItem("Club Form");
        ClubItem.addActionListener(this);

        BankMenu = new JMenu("BANK");
        BankItem = new JMenuItem("Bank Form");
        BankItem.addActionListener(this);
        
        leagueMenu = new JMenu("LEAGUE");
        leaguItem = new JMenuItem("LeagueForm");
        leaguItem.addActionListener(this);
        
        stadiuMenu = new JMenu("STADIUM");
        stadiuItem = new JMenuItem("STADIUM Form");
        stadiuItem.addActionListener(this);

        logoutMenu = new JMenu("LOGOUT");
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to respective menus
        PlayerMenu.add(PlayerItem);
        User_adminMenu.add(User_adminItem);
        ManagersMenu.add(ManagersItem);
        CoacherMenu.add(CoacherItem);
        leagueMenu.add(ClubItem);
        stadiuMenu.add(BankItem);
        logoutMenu.add(logoutItem);

        // Add menus to menu bar
        menuBar.add(PlayerMenu);
        menuBar.add(User_adminMenu);
        menuBar.add(ManagersMenu);
        menuBar.add(CoacherMenu);
        menuBar.add(ClubMenu);
        menuBar.add(BankMenu);
        menuBar.add(leagueMenu);
        menuBar.add(stadiuMenu);
        menuBar.add(logoutMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME"+loggedInUser+"TO THE NIYONSHUTI_Jean_Pierre_222003223");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == PlayerItem) {
            new PlayerForms();
        } else if (e.getSource() == User_adminItem) {
            new UserAdminform();
        } else if (e.getSource() == ManagersItem) {
            new Managerforms();
        } else if (e.getSource() == CoacherItem) {
            new CoacherForm();
        } else if (e.getSource() == ClubItem) {
            new ClubForm();
        } else if (e.getSource() == BankItem) {
            new BankForms();
        } else if (e.getSource() == stadiuItem) {
            new Stadiumforms();
        } else if (e.getSource() == leaguItem) {
            new Leagueforms();
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> new MENUFORM("TO THE NIYONSHUTI_Jean_Pierre_222003223"));
    }
}