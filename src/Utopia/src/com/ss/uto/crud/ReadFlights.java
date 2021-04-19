/**
 * 
 */
package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.entities.Flight;

/**
 * @author Parker W.
 *
 */
public class ReadFlights implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		GetFlight menu = new GetFlight();
		Flight flight;
		Scanner pause = new Scanner(System.in);
		do {
			flight = menu.getItem(conn);
			if(flight != null) {
				System.out.println(flight);
				System.out.println("Please press enter to continue...");
				pause.nextLine();
			}			
			
		} while (flight != null);

	}

}
