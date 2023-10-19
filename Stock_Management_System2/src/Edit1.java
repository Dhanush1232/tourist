import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Edit1 {
	
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost/main";
	// TODO Auto-generated method stub
	final static String USER = "root";
	final static String PASS = "Cse@123";

private JFrame frame;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Edit1 window = new Edit1();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the application.
*/
public Edit1() {
initialize();
}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.setBounds(100, 100, 856, 686);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JLabel lblNewLabel = new JLabel("Product Id:");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel.setBounds(240, 178, 125, 26);
frame.getContentPane().add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("Name:");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1.setBounds(240, 234, 125, 26);
frame.getContentPane().add(lblNewLabel_1);

textField = new JTextField();
textField.setBounds(459, 175, 107, 26);
frame.getContentPane().add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
textField_1.setBounds(459, 231, 107, 26);
frame.getContentPane().add(textField_1);
textField_1.setColumns(10);

JButton btnNewButton = new JButton("EDIT");
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	ResultSet rs;
	try {
		String a=textField.getText();
		String b = textField_1.getText();
		String c = textField_2.getText();
		String d = textField_3.getText();
		String f = textField_4.getText();
	Connection conn = null;
	Statement stmt = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	stmt = conn.createStatement();
	PreparedStatement ps = conn.prepareStatement("update product_item set product_id=?, product_name=?, product_uantity=?, product_price=?, product_type=? where product_id=?");
	
	           ps.setString(1, a);
	           ps.setString(2, b);
	           ps.setString(3, c);
	           ps.setString(4, d);
	           ps.setString(5, f);
	           ps.setString(6, a);
	ps.executeUpdate();

	       stmt.close();
	       conn.close();
	       JOptionPane.showMessageDialog(null,"Product Edited Successfully!...");    
	       first.main(null);
	} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
}
});
btnNewButton.setBounds(330, 496, 141, 39);
frame.getContentPane().add(btnNewButton);

JLabel lblNewLabel_2 = new JLabel("Edit Product");
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel_2.setBounds(347, 59, 165, 70);
frame.getContentPane().add(lblNewLabel_2);

JLabel lblNewLabel_3 = new JLabel("Quantity:");
lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_3.setBounds(240, 294, 125, 26);
frame.getContentPane().add(lblNewLabel_3);

textField_2 = new JTextField();
textField_2.setBounds(459, 291, 107, 26);
frame.getContentPane().add(textField_2);
textField_2.setColumns(10);

JLabel lblNewLabel_4 = new JLabel("Price:");
lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_4.setBounds(240, 360, 125, 26);
frame.getContentPane().add(lblNewLabel_4);

textField_3 = new JTextField();
textField_3.setBounds(459, 360, 107, 26);
frame.getContentPane().add(textField_3);
textField_3.setColumns(10);

JLabel lblNewLabel_5 = new JLabel("Quantity Type");
lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_5.setBounds(240, 428, 125, 26);
frame.getContentPane().add(lblNewLabel_5);

textField_4 = new JTextField();
textField_4.setBounds(459, 425, 107, 26);
frame.getContentPane().add(textField_4);
textField_4.setColumns(10);

JLabel lblNewLabel_6 = new JLabel("");
lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\dhanu\\Desktop\\stock\\images\\back2.jpg"));
lblNewLabel_6.setBounds(0, 0, 840, 647);
frame.getContentPane().add(lblNewLabel_6);
}
}
