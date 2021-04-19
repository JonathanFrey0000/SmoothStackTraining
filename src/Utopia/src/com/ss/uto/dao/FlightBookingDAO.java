/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entities.FlightBooking;

/**
 * @author Jonathan Frey
 *
 */
public class FlightBookingDAO extends BaseDAO<FlightBooking> {

	public FlightBookingDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<FlightBooking> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightBooking> bookings = new ArrayList<>();
		while (rs.next()) {
			BookingDAO bdao = new BookingDAO(conn);
			FlightDAO fdao = new FlightDAO(conn);
			FlightBooking booking = new FlightBooking();
			booking.setBooking(bdao.getData("select * from booking where id = ?", rs.getInt("booking_id")).get(0));
			booking.setFlight(fdao.getData("select * from flight where id = ?", rs.getInt("flight_id")).get(0));
		}
		return bookings;
	}

	@Override
	public Integer add(FlightBooking obj) throws ClassNotFoundException, SQLException {
		return super.addPK("insert into flight_booking (flight_id, booking_id) values (?,?)", obj.getFlight().getId(),
				obj.getBooking().getId());

	}

	@Override
	public void update(FlightBooking obj) throws ClassNotFoundException, SQLException {

	}

	@Override
	public void delete(FlightBooking obj) throws ClassNotFoundException, SQLException {
		super.update("delete from flight_booking where flight_id = ? and booking_id = ?", obj.getFlight().getId(),
				obj.getBooking().getId());

	}

	@Override
	public List<FlightBooking> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from flight_booking");
	}

}
