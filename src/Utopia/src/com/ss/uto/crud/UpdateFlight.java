/**
 * 
 */
package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;

import com.ss.uto.dao.FlightDAO;
import com.ss.uto.entities.Airplane;
import com.ss.uto.entities.Flight;
import com.ss.uto.entities.Route;

/**
 * @author Jonathan Frey
 *
 */
public class UpdateFlight implements Menu{

	@Override
	public void operate(Connection conn) throws SQLException {
		Flight flight = new GetFlight().getItem(conn);
		FlightDAO fdao = new FlightDAO(conn);
		Scanner input = new Scanner(System.in);
		//route_id
		Route route = new GetRoute().getItem(conn);
		flight.setRoute(route);
		//airplane_id
		Airplane plane = new GetAirplane().getItem(conn);
		flight.setPlane(plane);
		//departure_time
		Date date = new GetDeparture().getItem(conn);
		flight.setDepatureTime(date);
			
		//reserved_seats
		System.out.print("Please enter the number of reserved seats: ");
		Integer reservedSeats = input.nextInt();
		flight.setReservedSeats(reservedSeats);
		//seat_price
		System.out.print("\nPlease enter the price per seat: ");
		Float seatPrice = input.nextFloat();
		flight.setSeatPrice(seatPrice);
		
		try {
			fdao.update(flight);
			//id
			Integer id = input.nextInt();
			fdao.getData("update flight set id = ? where id = ?", id, flight.getId());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	

}
