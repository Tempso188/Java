package loginSystem;

import java.sql.Connection;

import java.sql.*;

public class operations {
	public boolean anmelden(String pBenutzername, String pPasswort) {
		try {
			Connection con = sqlConnection.getConnection();
			PreparedStatement pst;
			ResultSet res;
			pst = con.prepareStatement("select id from user where benutzername = ? and passwort = ?");
			pst.setString(1, pBenutzername);
			pst.setString(2, pPasswort);
			res = pst.executeQuery();

			while (res.next()) {
				loginSitzung.benutzerId = res.getInt("id");
				loginSitzung.benutzername = res.getString("benutzername");

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
