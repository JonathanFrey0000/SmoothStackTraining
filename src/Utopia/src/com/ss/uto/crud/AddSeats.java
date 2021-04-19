package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;

public class AddSeats implements Menu {


	@Override
	public void operate(Connection conn) throws SQLException {
		new UpdateSeats().operate(conn);
		
	}

}
