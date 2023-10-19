import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class front {

	private JFrame frame;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					front window = new front();
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
	public front() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 915, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STOCK MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 42));
		lblNewLabel.setBounds(77, 27, 792, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SIGNUP/LOGIN AS ADMIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.main(null);
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(302, 135, 259, 57);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSignuploginAsBill = new JButton("SIGNUP/LOGIN AS BILL MEMBER");
		btnSignuploginAsBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billmemberlogin.main(null);
			}
		});
		btnSignuploginAsBill.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnSignuploginAsBill.setBounds(302, 213, 259, 57);
		frame.getContentPane().add(btnSignuploginAsBill);
	}

}
