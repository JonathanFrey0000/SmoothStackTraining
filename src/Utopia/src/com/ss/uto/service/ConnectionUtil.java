/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Parker W.
 *
 *         Service class, handles connections to the server
 */
public class ConnectionUtil {

	private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/utopia";
    private static final String username = "root";
    private static final String password = "rootroot";
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
    	Class.forName(driver);
    	Connection con = DriverManager.getConnection(url, username, password);
    	con.setAutoCommit(Boolean.FALSE);
    	return con;
    }

}
