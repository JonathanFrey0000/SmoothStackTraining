/**
 * 
 */
package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.entities.Airport;

/**
 * @author Jonathan Frey
 *
 */
public class ReadAirports implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		GetAirport display = new GetAirport();
		Airport port;
		Scanner pause = new Scanner(System.in);
		do {
			port = display.getItem(conn);
			if(port != null) {
				System.out.println(port.toString());
				System.out.println("Press enter to continue...");
				pause.nextLine();
			}			
			
		} while(port != null);
	}
	

}
