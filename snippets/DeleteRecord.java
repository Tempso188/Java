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