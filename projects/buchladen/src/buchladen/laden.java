package buchladen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class laden {

	private JFrame frame;
	private JTextField textBuchname;
	private JTextField textAuflage;
	private JTextField textPreis;
	private JTable table;
	private JTextField textBuchId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					laden window = new laden();
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

	public laden() {
		initialize();
		Connect();
		table_load();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/buchladen", "root", "");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void table_load() {
		try {
			pst = con.prepareStatement("select * from buch");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 758, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Buchladen");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 11, 161, 48);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "registrieren", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 146, 248, 177);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Buchname");
		lblNewLabel_1.setBounds(10, 45, 76, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Auflage");
		lblNewLabel_2.setBounds(10, 88, 46, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Preis");
		lblNewLabel_3.setBounds(10, 140, 46, 14);
		panel.add(lblNewLabel_3);

		textBuchname = new JTextField();
		textBuchname.setBounds(130, 42, 86, 20);
		panel.add(textBuchname);
		textBuchname.setColumns(10);

		textAuflage = new JTextField();
		textAuflage.setBounds(130, 85, 86, 20);
		panel.add(textAuflage);
		textAuflage.setColumns(10);

		textPreis = new JTextField();
		textPreis.setBounds(130, 137, 86, 20);
		panel.add(textPreis);
		textPreis.setColumns(10);

		JButton btnSave = new JButton("Speichern");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bName;
				String bAuflage;
				String bPreis;

				bName = textBuchname.getText();
				bAuflage = textAuflage.getText();
				bPreis = textPreis.getText();

				try {
					pst = con.prepareStatement("insert into buch(name,auflage,preis)values(?,?,?)");
					pst.setString(1, bName);
					pst.setString(2, bAuflage);
					pst.setString(3, bPreis);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Buch hinzugefuegt");
					table_load();

					textBuchname.setText("");
					textAuflage.setText("");
					textPreis.setText("");
					textBuchname.requestFocusInWindow();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});

		btnSave.setBounds(43, 334, 89, 23);
		frame.getContentPane().add(btnSave);

		JButton btnLeeren = new JButton("leeren");
		btnLeeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textBuchname.setText("");
				textAuflage.setText("");
				textPreis.setText("");
			}
		});
		btnLeeren.setBounds(155, 334, 89, 23);
		frame.getContentPane().add(btnLeeren);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 60, 329, 263);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Suche", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 61, 301, 74);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Buch ID");
		lblNewLabel_1_1.setBounds(22, 29, 76, 14);
		panel_1.add(lblNewLabel_1_1);

		textBuchId = new JTextField();
		textBuchId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {

					String id = textBuchId.getText();

					pst = con.prepareStatement("select name,auflage,preis from buch where id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();

					if (rs.next() == true) {

						String name = rs.getString(1);
						String auflage = rs.getString(2);
						String preis = rs.getString(3);

						textBuchname.setText(name);
						textAuflage.setText(auflage);
						textPreis.setText(preis);

					} else {
						textBuchname.setText("");
						textAuflage.setText("");
						textPreis.setText("");

					}

				}

				catch (SQLException ex) {

				}

			}
		});
		textBuchId.setColumns(10);
		textBuchId.setBounds(142, 26, 86, 20);
		panel_1.add(textBuchId);

		JButton btnNewButton_1 = new JButton("Aktualisieren");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String bName;
				String bAuflage;
				String bPreis;
				String bId;

				bName = textBuchname.getText();
				bAuflage = textAuflage.getText();
				bPreis = textPreis.getText();
				bId = textBuchId.getText();

				try {
					pst = con.prepareStatement("update buch set name= ?,auflage=?,preis=? where id =?");
					pst.setString(1, bName);
					pst.setString(2, bAuflage);
					pst.setString(3, bPreis);
					pst.setString(4, bId);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Buch aktualisiert");
					table_load();

					textBuchname.setText("");
					textAuflage.setText("");
					textPreis.setText("");
					textBuchId.setText("");
					textBuchname.requestFocus();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(412, 334, 108, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("loeschen");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bId;
				bId = textBuchId.getText();
				try {
					pst = con.prepareStatement("delete from buch where id =?");

					pst.setString(1, bId);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Buchnummer:" + bId + " geloescht");
					table_load();

					textBuchname.setText("");
					textAuflage.setText("");
					textPreis.setText("");
					textBuchname.requestFocus();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
			}

		});
		btnNewButton_2.setBounds(602, 334, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
