package loginSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textBenutzername;
	private JTextField textPasswort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUI frame = new loginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public loginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textBenutzername = new JTextField();
		textBenutzername.setBounds(98, 33, 156, 20);
		contentPane.add(textBenutzername);
		textBenutzername.setColumns(10);
		
		textPasswort = new JTextField();
		textPasswort.setColumns(10);
		textPasswort.setBounds(98, 58, 156, 20);
		contentPane.add(textPasswort);
		
		JLabel lblNewLabel = new JLabel("Benutzername :");
		lblNewLabel.setBounds(10, 36, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasswort = new JLabel("Passwort :");
		lblPasswort.setBounds(35, 61, 78, 14);
		contentPane.add(lblPasswort);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAnmelden = new JButton("Anmelden");
		btnAnmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operations op = new operations();
				try {
					String benutzername = textBenutzername.getText();
					String passwort = textPasswort.getText();
					if(op.anmelden(benutzername, passwort)) {
						new angemeldetUI().setVisible(true);
						dispose();
					}
					else JOptionPane.showMessageDialog(null, "falsche daten");
				}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "falsche daten");
			}
		}});
		btnAnmelden.setBounds(171, 87, 83, 23);
		contentPane.add(btnAnmelden);
	}

}
