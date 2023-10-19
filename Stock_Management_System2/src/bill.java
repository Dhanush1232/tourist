import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class bill {
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
private static JTable table;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
bill window = new bill();
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
	String id1=String.valueOf(rs.getInt("product_id"));
	String pname1=rs.getString("product_name");
	String pquan1=String.valueOf(rs.getInt("product_uantity"));
	String price1=String.valueOf(rs.getInt("product_price"));
	String type1=rs.getString("product_type");
	String a1[]= {id1,pname1,pquan1,price1,type1};
	DefaultTableModel tb1=(DefaultTableModel)table.getModel();
	tb1.addRow(a1);}
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the application.
*/
public bill() {
initialize();
}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.setBounds(100, 100, 1142, 556);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JLabel lblNewLabel_1 = new JLabel("Bill");
lblNewLabel_1.setBounds(352, 55, 95, 26);
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
frame.getContentPane().add(lblNewLabel_1);

JLabel lblNewLabel = new JLabel("Product  Id:");
lblNewLabel.setBounds(193, 153, 101, 26);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
frame.getContentPane().add(lblNewLabel);

JLabel lblNewLabel_2 = new JLabel("Quantity:");
lblNewLabel_2.setBounds(193, 208, 101, 26);
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
frame.getContentPane().add(lblNewLabel_2);

textField = new JTextField();
textField.setBounds(389, 156, 127, 26);
frame.getContentPane().add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
textField_1.setBounds(389, 208, 127, 26);
frame.getContentPane().add(textField_1);
textField_1.setColumns(10);

JLabel lblNewLabel_3 = new JLabel("Product name:");
lblNewLabel_3.setBounds(193, 268, 111, 26);
lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
frame.getContentPane().add(lblNewLabel_3);

JLabel lblNewLabel_4 = new JLabel("Customer Name:");
lblNewLabel_4.setBounds(193, 322, 160, 26);
lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
frame.getContentPane().add(lblNewLabel_4);

textField_2 = new JTextField();
textField_2.setBounds(389, 271, 127, 26);
frame.getContentPane().add(textField_2);
textField_2.setColumns(10);

textField_3 = new JTextField();
textField_3.setBounds(389, 325, 127, 26);
frame.getContentPane().add(textField_3);
textField_3.setColumns(10);

JButton btnNewButton = new JButton("Add to cart");
btnNewButton.setBounds(193, 422, 136, 32);
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			ResultSet rs;
			final String u=textField.getText();
			final String v =textField_1.getText();
		//	final String w=textField_2.getText();
			//final String x =textField_3.getText();
			
			int u1= Integer.parseInt(u);
			int v1=Integer.parseInt(v);
		Connection conn = null;
		Statement stmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
		PreparedStatement ps1 = conn.prepareStatement("select product_uantity from product_item where product_id=?");
		ps1.setString(1, u);
		rs=ps1.executeQuery();
		//rs.beforeFirst();
		int ab = 0;
		while(rs.next()) {
		ab=ab+rs.getInt("product_uantity");
		}
		System.out.println(ab);
		int c = Integer.parseInt(v);
		if(c>ab) {
			 JOptionPane.showMessageDialog(null,"Quantity is insufficient");  
		}
		/*else {
		PreparedStatement ps = conn.prepareStatement("insert into bill values(?, ?, ?, ?)");
		ps.setInt(1, u1);
        ps.setInt(2, v1);
        ps.setString(3, w);
        ps.setString(4, x);
		ps.executeUpdate();
	    textField.setText("");
	    textField_1.setText("");
	    textField_2.setText("");
		       stmt.close();
		       conn.close();
		       JOptionPane.showMessageDialog(null,"Add to cart successfully....");      
		} */
		else {
			JOptionPane.showMessageDialog(null,"Add to cart successfully....");   
			billpage.main(null);
		}
		}
		catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		
	}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
frame.getContentPane().add(btnNewButton);
JButton btnNewButton_1 = new JButton("GENERATE BILL");
btnNewButton_1.setBounds(377, 422, 149, 32);
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		try {
		ResultSet rs1;
		Connection conn = null;
		Statement stmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
		System.out.print("1");
		String sql="Select product_id,Quantity from bill";
		
		rs1=stmt.executeQuery(sql);
		while(rs1.next()) {
			System.out.print("1");
		    int pid=rs1.getInt("product_id");
		    String pid1=Integer.toString(pid);
		    int quan=rs1.getInt("Quantity");
		    String quan1=Integer.toString(quan);
			PreparedStatement ps = conn.prepareStatement("update product_item set product_uantity=product_uantity-? where product_id=?");
			ps.setString(1, quan1);
			ps.setString(2, pid1);
			ps.executeUpdate();
		}
		billpage.main(null);
		}
		catch(Exception ex)
		{
			
		}
	}
});
btnNewButton_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 10));
frame.getContentPane().add(btnNewButton_1);
JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(639, 120, 444, 334);
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
JLabel lblNewLabel_1_1 = new JLabel("PRODUCT LIST");
lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel_1_1.setBounds(755, 55, 199, 26);
frame.getContentPane().add(lblNewLabel_1_1);
}
}