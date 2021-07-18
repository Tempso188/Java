import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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