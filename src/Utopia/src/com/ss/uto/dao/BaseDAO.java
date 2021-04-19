/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Jonathan Frey
 *
 */
public abstract class BaseDAO<T> {

	Connection conn = null;

	public BaseDAO(Connection conn) {
		this.conn = conn;
	}

	public Integer addPK(String query, Object... vals) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		int count = 1;
		for (Object o : vals) {
			stmt.setObject(count++, o);
		}
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next())
			return rs.getInt(1);
		return null;
	}

	public void update(String query, Object... vals) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = conn.prepareStatement(query);
		int count = 1;
		for (Object o : vals) {
			stmt.setObject(count++, o);
		}
		stmt.executeUpdate();
	}

	public List<T> getData(String query, Object... vals) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = conn.prepareStatement(query);
		int count = 1;
		for (Object o : vals) {
			stmt.setObject(count++, o);
		}
		ResultSet rs = stmt.executeQuery();
		return parseData(rs);
	}

	protected abstract List<T> parseData(ResultSet rs) throws ClassNotFoundException, SQLException;

	public abstract Integer add(T obj) throws ClassNotFoundException, SQLException;

	public abstract void update(T obj) throws ClassNotFoundException, SQLException;

	public abstract void delete(T obj) throws ClassNotFoundException, SQLException;

	public abstract List<T> getAll() throws ClassNotFoundException, SQLException;

}
