import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class billpage {
	static //Component total;
	int tot=0;
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost/main";
	// TODO Auto-generated method stub
	final static String USER = "root";
	final static String PASS = "Cse@123";

	private JFrame frame;
	private static JTable table;
	private static JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					billpage window = new billpage();
					window.frame.setVisible(true);
					ResultSet rs,rs1;
					Connection conn = null;
					Statement stmt = null;
					Statement stmt1 = null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
					stmt = conn.createStatement();
					stmt1 =conn.createStatement();
					String sql="select product_id,product_name,Quantity from bill";
					rs=stmt.executeQuery(sql);
					//if(rs.next()) {
						//System.out.print("1");
					//}
					while(rs.next()) {
						//System.out.print("1");
						String id=String.valueOf(rs.getInt("product_id"));
						String pname=rs.getString("product_name");
						//String pq=rs.getString("Q");
						int pquan=rs.getInt("Quantity");
						String pq=Integer.toString(pquan);
						//System.out.print(id);
						PreparedStatement ps = conn.prepareStatement("select * from product_item where product_id=?");
						
						ps.setString(1,id);
						rs1=ps.executeQuery();
						rs1.next();
						//{
							//System.out.print("1");
						//}
						int p=rs1.getInt("product_price");
						///System.out.println(p);
						int price=p*pquan;
						tot=tot+price;
						//System.out.println(price);
						String fprice=Integer.toString(price);
						String a[]= {pname,pq,fprice};
						DefaultTableModel tb1=(DefaultTableModel)table.getModel();
						tb1.addRow(a);
						
					}
					//total=tot;
					//lblNewLabel.
					String tot1=Integer.toString(tot); 
					textField.setText(tot1);
					
					String sql1="truncate table bill";
					stmt1.executeUpdate(sql1);
					System.out.print("1");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public billpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//String b="BILL"
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("BILL");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 35));
		lblNewLabel.setBounds(344, 42, 103, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(166, 89, 449, 280);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product Name", "Quantity", "Price"
			}
		));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(579, 418, 96, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Total Amount : ");
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(478, 417, 135, 36);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
