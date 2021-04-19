/**
 * 
 */
package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Jonathan Frey
 *
 */
public interface Menu {

	public abstract void operate(Connection conn) throws SQLException;

}
