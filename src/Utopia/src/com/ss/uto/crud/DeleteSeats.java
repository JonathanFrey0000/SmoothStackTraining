/**
 * 
 */
package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Parker W.
 *
 */
public class DeleteSeats implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		//due to the lack of seat types this can utilize the UpdateSeatsMenu
		new UpdateSeats().operate(conn);		
	}

	

}
