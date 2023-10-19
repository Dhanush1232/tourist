import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;

public class login {
private static JTextField textField;
private static JPasswordField passwordField;
final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
final static String DB_URL = "jdbc:mysql://localhost/main";
// TODO Auto-generated method stub
final static String USER = "root";
final static String PASS = "Cse@123";
private static JTextField textField_1;
private static JPasswordField passwordField_1;
/**
* @wbp.parser.entryPoint
*/
public static void main(String args[]) {
JFrame f=new JFrame();
f.getContentPane().setLayout(null);
f.setBounds(100, 100, 1283, 677);
JPanel panel = new JPanel();
panel.setBounds(0, 0, 1269, 640);
f.getContentPane().add(panel);
panel.setLayout(null);

JLabel lblNewLabel = new JLabel("Username:");
lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 21));
lblNewLabel.setBounds(60, 278, 136, 20);
panel.add(lblNewLabel);

textField = new JTextField();
textField.setBounds(231, 267, 195, 31);
panel.add(textField);
textField.setColumns(10);
passwordField = new JPasswordField();
passwordField.setBounds(231, 325, 195, 31);
panel.add(passwordField);

JButton btnNewButton = new JButton("LOGIN");
btnNewButton.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 19));
btnNewButton.setForeground(new Color(0, 0, 0));
btnNewButton.setBackground(new Color(240, 240, 240));
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
final String u=textField.getText();
final char[] str=passwordField.getPassword();
final String p = new String(str);
ResultSet rs;
try {
Connection conn = null;
Statement stmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL,USER,PASS);
stmt = conn.createStatement();
PreparedStatement ps = conn.prepareStatement("select * from tourist where name=? and password=?");
           ps.setString(1, u);
           ps.setString(2, p);
rs = ps.executeQuery();
if(rs.next()){
	JOptionPane.showMessageDialog(null,"login successfully.........");     
    first.main(null);	
}
else {
JOptionPane.showMessageDialog(null,"Incorrect Username or password..Try Again with correct detail");
}
       stmt.close();
       conn.close();
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
}
});
btnNewButton.setBounds(181, 421, 151, 46);
panel.add(btnNewButton);
JLabel lblNewLabel_2 = new JLabel("ADMINISTRATOR REGISTER AND LOGIN");
lblNewLabel_2.setForeground(new Color(0, 0, 0));
lblNewLabel_2.setFont(new Font("Algerian", Font.BOLD, 46));
lblNewLabel_2.setBounds(181, 36, 1190, 46);
panel.add(lblNewLabel_2);
JLabel lblNewLabel_3 = new JLabel("LOGIN");
lblNewLabel_3.setForeground(new Color(0, 0, 0));
lblNewLabel_3.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
lblNewLabel_3.setBounds(181, 222, 84, 16);
panel.add(lblNewLabel_3);
textField_1 = new JTextField();
textField_1.setBounds(960, 267, 230, 32);
panel.add(textField_1);
textField_1.setColumns(10);
passwordField_1 = new JPasswordField();
passwordField_1.setBounds(960, 325, 234, 31);
panel.add(passwordField_1);
JLabel lblPassword = new JLabel("PASSWORD:");
lblPassword.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 21));
lblPassword.setBounds(60, 327, 161, 20);
panel.add(lblPassword);
JLabel lblNewLabel_1 = new JLabel("Username:");
lblNewLabel_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 21));
lblNewLabel_1.setBounds(779, 278, 136, 20);
panel.add(lblNewLabel_1);
JLabel lblPassword_1 = new JLabel("PASSWORD:");
lblPassword_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 21));
lblPassword_1.setBounds(768, 337, 161, 20);
panel.add(lblPassword_1);
JButton btnSignUp = new JButton("SIGN UP");
btnSignUp.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		ResultSet rs;
		try {
			String u=textField_1.getText();
			final char[] str=passwordField_1.getPassword();
			final String p = new String(str);
		Connection conn = null;
		Statement stmt = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
		PreparedStatement ps = conn.prepareStatement("insert into tourist(name,password) values(?,?)");
		           ps.setString(1, u);
		           ps.setString(2, p);
		ps.executeUpdate();
	
		       stmt.close();
		       conn.close();
		       JOptionPane.showMessageDialog(null,"User added Successfully , you can login now!....");      
		} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
	}
});
btnSignUp.setForeground(new Color(0, 0, 0));
btnSignUp.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 19));
btnSignUp.setBackground(SystemColor.menu);
btnSignUp.setBounds(958, 421, 151, 46);
panel.add(btnSignUp);
JLabel lblNewLabel_3_1 = new JLabel("SIGN UP");
lblNewLabel_3_1.setForeground(new Color(0, 0, 0));
lblNewLabel_3_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
lblNewLabel_3_1.setBounds(914, 222, 111, 16);
panel.add(lblNewLabel_3_1);

f.setVisible(true);
}
}