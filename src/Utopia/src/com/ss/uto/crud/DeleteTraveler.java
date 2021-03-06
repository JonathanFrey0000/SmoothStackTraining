package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.PassengerDAO;
import com.ss.uto.entities.Passenger;
/**
 * @author Jonathan Frey
 *
 */
public class DeleteTraveler implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		Passenger passenger = new GetPassenger().getItem(conn);
		PassengerDAO pdao = new PassengerDAO(conn);

		System.out.println("Warning: Deleting the passenger can not be undone.");
		System.out.println("Enter \"confirm\" to delete passenger : " + passenger);
		Scanner input = new Scanner(System.in);
		if (input.nextLine().equals("confirm")) {
			try {
				pdao.delete(passenger);
				System.out.println("Deleted passenger.");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Deletion canceled.");
		}

	}

}
