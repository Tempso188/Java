package loginSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class angemeldetUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					angemeldetUI frame = new angemeldetUI();
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
	public angemeldetUI() {
		String benutzername = loginSitzung.benutzername;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 214, 119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAngemeldetAls = new JLabel(benutzername);
		lblAngemeldetAls.setBounds(128, 11, 57, 14);
		contentPane.add(lblAngemeldetAls);
		
		JButton btnAbmelden = new JButton("Abmelden");
		btnAbmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginUI ui = new loginUI();
				ui.setVisible(true);
				loginSitzung.angemeldet = false;
				dispose();
			}
		});
		btnAbmelden.setBounds(52, 36, 89, 23);
		contentPane.add(btnAbmelden);
		
		JLabel lblNewLabel = new JLabel("Angemeldet als :");
		lblNewLabel.setBounds(23, 11, 89, 14);
		contentPane.add(lblNewLabel);
	}

}
