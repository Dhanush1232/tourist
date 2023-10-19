import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

public class first {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost/main";
	// TODO Auto-generated method stub
	final static String USER = "root";
	final static String PASS = "Cse@123";

private JFrame frame;
private static JTable table;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
first window = new first();
window.frame.setVisible(true);
ResultSet rs;
Connection conn = null;
Statement stmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
String sql="select * from product_item";
rs=stmt.executeQuery(sql);
while(rs.next()) {
	String id=String.valueOf(rs.getInt("product_id"));
	String pname=rs.getString("product_name");
	String pquan=String.valueOf(rs.getInt("product_uantity"));
	String price=String.valueOf(rs.getInt("product_price"));
	String type=rs.getString("product_type");
	String a[]= {id,pname,pquan,price,type};
	DefaultTableModel tb1=(DefaultTableModel)table.getModel();
	tb1.addRow(a);}
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the application.
*/
public first() {
initialize();
}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.setBounds(100, 100, 863, 658);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JLabel lblNewLabel = new JLabel("MANAGE PRODUCTS");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
lblNewLabel.setBounds(350, 58, 297, 45);
frame.getContentPane().add(lblNewLabel);

JButton btnNewButton = new JButton("Add");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Edit.main(null);
	}
});
btnNewButton.setBounds(229, 140, 89, 23);
frame.getContentPane().add(btnNewButton);

JButton btnNewButton_1 = new JButton("Edit");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	Edit1.main(null);
}
});
btnNewButton_1.setBounds(458, 140, 89, 23);
frame.getContentPane().add(btnNewButton_1);

JButton btnNewButton_2 = new JButton("Delete");
btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		delete.main(null);
	}
});
btnNewButton_2.setBounds(705, 140, 89, 23);
frame.getContentPane().add(btnNewButton_2);


JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(229, 219, 563, 287);
frame.getContentPane().add(scrollPane);
table = new JTable();
table.setModel(new DefaultTableModel(
	new Object[][] {
	},
	new String[] {
		"product Id", "Name", "Quantity", "Price", "Product Type"
	}
));
scrollPane.setViewportView(table);
}
}