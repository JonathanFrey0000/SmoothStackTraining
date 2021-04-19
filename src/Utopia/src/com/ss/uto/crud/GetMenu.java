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
public interface GetMenu<T> {

	public T getItem(Connection conn) throws SQLException;
	
}
