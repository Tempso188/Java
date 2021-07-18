import net.proteanit.sql.DbUtils;

public void table_load() {
		try {
			pst = con.prepareStatement("select * from buch");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}