package otherExamples;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class Frontsiseplayer {
	public void main(String[] args) {
		        JFrame frame = new JFrame("Font and Table Example");
		        frame.setSize(600, 300);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        // Font Example
		        JLabel label = new JLabel("Custom Font Example");
		        Font customFont = new Font("Courier New", Font.BOLD, 18);
		        label.setFont(customFont);

		        // Table Example
		        String[] columnNames = {"last_name", "position", "club_id"};
		        Object[][] data = {
		                {"Kimenyi", "goalkeeper", 1},
		                {"Bakame","forword",5},
		                {"Bob Johnson", "defence", 3}
		        };

		        JTable table = new JTable(new DefaultTableModel(data, columnNames));

		        // Add components to the frame
		        frame.setLayout(new GridLayout(2, 1));
		        frame.add(label);
		        frame.add(new JScrollPane(table)); // Use JScrollPane for the table

		        frame.setVisible(true);
		    }
		}
