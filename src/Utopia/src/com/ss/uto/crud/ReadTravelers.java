/**
 * 
 */
package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.entities.Passenger;

/**
 * @author Jonathan Frey
 *
 */
public class ReadTravelers implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		GetPassenger display = new GetPassenger();
		Passenger passenger;
		Scanner pause = new Scanner(System.in);
		do {
			passenger = display.getItem(conn);
			if(passenger != null) {
				System.out.println(passenger.toString());
				System.out.println("Press enter to continue...");
				pause.nextLine();
			}
			

		} while(passenger != null);
		
	}

	

}
