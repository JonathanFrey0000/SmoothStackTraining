package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.crud.GetFlight;
import com.ss.uto.crud.UpdateFlight;
import com.ss.uto.crud.UpdateSeats;
import com.ss.uto.entities.Flight;
/**
 * @author Jonathan Frey
 *
 */
public class EmployeeService {

	ConnectionUtil conUtil;
	Connection conn = null;

	public EmployeeService() {
		conUtil = new ConnectionUtil();
	}

	public void employeeMenuOne() throws SQLException {
		System.out.println("1) Enter Flight you manage");
		System.out.println("2) Quit to previous");
		Scanner input = new Scanner(System.in);
		Integer choice;
		do {
			choice = input.nextInt();
			switch (choice) {
			case 1:
				manageFlight();
				break;
			case 2:
				return;
			default:
				System.out.println("Invalid selection, returning to main menu.");
				return;
			}
		} while (true);

	}

	public void manageFlight() throws SQLException {
		GetFlight flightMenu = new GetFlight();
		try {
			Flight flight = flightMenu.getItem(conn);
			System.out.println("1) View flight details.");
			System.out.println("2) Update flight details.");
			System.out.println("3) Add seats to flight.");
			System.out.println("4) Quit to previous.");

			Scanner input = new Scanner(System.in);
			Integer choice = input.nextInt();
			boolean done = false;
			do {
				switch (choice) {
				case 1:
					System.out.println(flight);
					break;
				case 2:
					UpdateFlight updateFlightMenu = new UpdateFlight();
					updateFlightMenu.operate(conn);
					break;
				case 3:
					UpdateSeats updateSeatsMenu = new UpdateSeats();
					updateSeatsMenu.operate(conn);
					break;
				case 4:
					System.out.println("Returning to previous menu");
					done = true;
					break;
				default:
					System.out.println("Unkown choice selection, returning to previous menu.");
					done = true;
					break;
				}

			} while (!done);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
}
