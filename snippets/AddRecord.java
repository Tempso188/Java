import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public void actionPerformed(ActionEvent e) {
				String bName;
				String bAuflage;
				String bPreis;

				bName = textBuchname.getText();
				bAuflage = textAuflage.getText();
				bPreis = textPreis.getText();

				try {
					pst = con.prepareStatement("insert into buch(name,auflage,preis)values(?,?,?)"); //sql line
					pst.setString(1, bName);
					pst.setString(2, bAuflage); // fill ?
					pst.setString(3, bPreis);
					pst.executeUpdate(); // excecute Upadeted sql line
					JOptionPane.showMessageDialog(null, "Buch hinzugefuegt"); // optional pop up windows with message
					table_load(); // load table with database elements

					textBuchname.setText("");
					textAuflage.setText(""); // set fields blank
					textPreis.setText("");
					textBuchname.requestFocusInWindow(); // input focus to Buchname field
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
			}