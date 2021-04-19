/**
 * 
 */
package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.entities.User;

/**
 * @author Jonathan Frey
 *
 */
public class ReadEmployees implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException{
		GetEmployee selectionMenu = new GetEmployee();
		User employee;
		Scanner pause = new Scanner(System.in);
		do {
			employee = selectionMenu.getItem(conn);
			if(employee != null) {
				System.out.println(employee.toString());
				System.out.println("Press enter to contine...");
				pause.nextLine();
			}			
		} while( employee != null);
	}

}
