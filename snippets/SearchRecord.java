import java.awt.event.KeyEvent;
import java.sql.ResultSet;

public void keyReleased(KeyEvent e) {

				try {

					String id = textBuchId.getText(); // parameter e.g here PRIMARY_KEY

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
		