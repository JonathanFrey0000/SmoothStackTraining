package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.crud.AddAirport;
import com.ss.uto.crud.AddEmployee;
import com.ss.uto.crud.AddFlight;
import com.ss.uto.crud.AddSeats;
import com.ss.uto.crud.AddTicketsAndPassengers;
import com.ss.uto.crud.AddTravelers;
import com.ss.uto.crud.DeleteAirport;
import com.ss.uto.crud.DeleteEmployee;
import com.ss.uto.crud.DeleteFlight;
import com.ss.uto.crud.DeleteSeats;
import com.ss.uto.crud.DeleteTicketsAndPassengers;
import com.ss.uto.crud.DeleteTraveler;
import com.ss.uto.crud.OverrideCancellation;
import com.ss.uto.crud.ReadAirports;
import com.ss.uto.crud.ReadEmployees;
import com.ss.uto.crud.ReadFlights;
import com.ss.uto.crud.ReadSeats;
import com.ss.uto.crud.ReadTicketsAndPassengers;
import com.ss.uto.crud.ReadTravelers;
import com.ss.uto.crud.UpdateAirport;
import com.ss.uto.crud.UpdateEmployee;
import com.ss.uto.crud.UpdateFlight;
import com.ss.uto.crud.UpdateSeats;
import com.ss.uto.crud.UpdateTicketsAndPassengers;
import com.ss.uto.crud.UpdateTraveler;

/**
 * @author Jonathan Frey
 *
 */
public class AdministratorService {
	ConnectionUtil conUtil;
	Connection conn;

	public AdministratorService() {
		conUtil = new ConnectionUtil();
	}

	public void mainAdminMenu() throws SQLException {

		

		Scanner input;
		Integer choice;
		do {
			System.out.println("1) Add/Update/Delete/Read flights");
			System.out.println("2) Add/Update/Delete/Read seats");
			System.out.println("3) Add/Update/Delete/Read tickets");
			System.out.println("4) Add/Update/Delete/Read airports");
			System.out.println("5) Add/Update/Delete/Read travelers");
			System.out.println("6) Add/Update/Delete/Read employees");
			System.out.println("7) Add/Update/Delete/Read cancellations");
			System.out.println("8) Quit");
			input = new Scanner(System.in);
			choice = input.nextInt();
			switch (choice) {
			case 1:
				flightMenu();
				break;
			case 2:
				seatMenu();
				break;
			case 3:
				ticketMenu();
				break;
			case 4:
				airportMenu();
				break;
			case 5:
				travelerMenu();
				break;
			case 6:
				employeeMenu();
				break;
			case 7:
				overrideTripCancellation();
				break;
			case 8:
			default:
				return;

			}
		} while (true);

	}

	public void employeeMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();
		switch (choice) {
		case 1:
			readEmployee();
			break;
		case 2:
			addEmployee();
			break;
		case 3:
			updateEmployee();
			break;
		case 4:
			deleteEmployee();
			break;
		case 5:
		default:
			return;

		}

	}

	public void travelerMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();
		switch (choice) {
		case 1:
			readTraveler();
			break;
		case 2:
			addTraveler();
			break;
		case 3:
			updateTraveler();
			break;
		case 4:
			deleteTraveler();
			break;
		case 5:
		default:
			return;

		}

	}

	public void airportMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();

		switch (choice) {
		case 1:
			readAirport();
			break;
		case 2:
			addAirport();
			break;
		case 3:
			updateAirport();
			break;
		case 4:
			deleteAirport();
			break;
		case 5:
		default:
			return;
		}

	}

	public void ticketMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();

		switch (choice) {
		case 1:
			readTicketsPassengers();
			break;
		case 2:
			addTicketsPassengers();
			break;
		case 3:
			updateTicketsPassengers();
			break;
		case 4:
			deleteTicketsPassengers();
			break;
		case 5:
		default:
			return;

		}

	}

	public void flightMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();

		switch (choice) {
		case 1:
			readFlight();
			break;
		case 2:
			addFlight();
			break;
		case 3:
			updateFlight();
			break;
		case 4:
			deleteFlight();
			break;
		case 5:
		default:
			return;

		}

	}

	public void seatMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();

		switch (choice) {
		case 1:
			readSeat();
			break;
		case 2:
			addSeat();
			break;
		case 3:
			updateSeat();
			break;
		case 4:
			deleteSeat();
			break;
		case 5:
		default:
			return;

		}

	}

	public void addFlight() throws SQLException {

		try {
			conn = conUtil.getConnection();

			AddFlight menu = new AddFlight();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void updateFlight() throws SQLException {
		try {
			conn = conUtil.getConnection();

			UpdateFlight menu = new UpdateFlight();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteFlight() throws SQLException {
		try {
			conn = conUtil.getConnection();

			DeleteFlight menu = new DeleteFlight();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void readFlight() throws SQLException {
		try {
			conn = conUtil.getConnection();

			ReadFlights menu = new ReadFlights();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void addSeat() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight.

		// suppose that the seats table is replaced by the difference between
		// airplane_type.max_capacity and flight.reserved_seats with no difference in
		// classes on account of the single flight.seat_price
		try {
			conn = conUtil.getConnection();

			AddSeats menu = new AddSeats();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void updateSeat() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight.

		// suppose that the seats table is replaced by the difference between
		// airplane_type.max_capacity and flight.reserved_seats with no difference in
		// classes on account of the single flight.seat_price
		try {
			conn = conUtil.getConnection();

			UpdateSeats menu = new UpdateSeats();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void deleteSeat() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight.

		// suppose that the seats table is replaced by the difference between
		// airplane_type.max_capacity and flight.reserved_seats with no difference in
		// classes on account of the single flight.seat_price
		try {
			conn = conUtil.getConnection();

			DeleteSeats menu = new DeleteSeats();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void readSeat() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight.

		// suppose that the seats table is replaced by the difference between
		// airplane_type.max_capacity and flight.reserved_seats with no difference in
		// classes on account of the single flight.seat_price
		try {
			conn = conUtil.getConnection();

			ReadSeats menu = new ReadSeats();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void addTicketsPassengers() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table and use
		// the passenger table
		try {
			conn = conUtil.getConnection();

			AddTicketsAndPassengers menu = new AddTicketsAndPassengers();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void updateTicketsPassengers() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table
		try {
			conn = conUtil.getConnection();

			UpdateTicketsAndPassengers menu = new UpdateTicketsAndPassengers();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteTicketsPassengers() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table and use
		// the passenger table
		try {
			conn = conUtil.getConnection();

			DeleteTicketsAndPassengers menu = new DeleteTicketsAndPassengers();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void readTicketsPassengers() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table and use
		// the passenger table
		try {
			conn = conUtil.getConnection();

			ReadTicketsAndPassengers menu = new ReadTicketsAndPassengers();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void addAirport() throws SQLException {
		try {
			conn = conUtil.getConnection();
			AddAirport menu = new AddAirport();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error adding the airport to the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void updateAirport() throws SQLException {
		try {
			conn = conUtil.getConnection();
			UpdateAirport menu = new UpdateAirport();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error updating the airport to the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteAirport() throws SQLException {
		try {
			conn = conUtil.getConnection();
			DeleteAirport menu = new DeleteAirport();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error deleting the airport from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void readAirport() throws SQLException {
		try {
			conn = conUtil.getConnection();
			ReadAirports menu = new ReadAirports();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error reading the airport from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void addTraveler() throws SQLException {
		try {
			conn = conUtil.getConnection();
			AddTravelers menu = new AddTravelers();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error adding the passenger to the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void updateTraveler() throws SQLException {
		try {
			conn = conUtil.getConnection();
			UpdateTraveler menu = new UpdateTraveler();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error updating the passenger in the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteTraveler() throws SQLException {
		// assumed to actually be the passenger table
		try {
			conn = conUtil.getConnection();
			DeleteTraveler menu = new DeleteTraveler();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error deleting the passenger from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void readTraveler() throws SQLException {
		// assumed to actually be the passenger table
		try {
			conn = conUtil.getConnection();
			ReadTravelers menu = new ReadTravelers();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error reading the passenger from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void addEmployee() throws SQLException {
		try {
			conn = conUtil.getConnection();
			AddEmployee menu = new AddEmployee();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error adding the employee to the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void updateEmployee() throws SQLException {
		try {
			conn = conUtil.getConnection();
			UpdateEmployee menu = new UpdateEmployee();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error updating the employee in the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteEmployee() throws SQLException {
		try {
			conn = conUtil.getConnection();
			DeleteEmployee menu = new DeleteEmployee();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error deleting the employee from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void readEmployee() throws SQLException {
		try {
			conn = conUtil.getConnection();
			ReadEmployees menu = new ReadEmployees();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error reading the employee from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void overrideTripCancellation() throws SQLException {
		
	}

}
