/**
 * 
 */
package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.UserDAO;
import com.ss.uto.entities.User;

/**
 * @author Jonathan Frey
 *
 */
public class DeleteEmployee implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {

		User workingUser = new GetEmployee().getItem(conn);
		Scanner input = new Scanner(System.in);
		UserDAO udao = new UserDAO(conn);

		System.out.println("WARNING: You are about to delete the following employee");
		System.out.println(workingUser.toString());
		System.out.println("This can NOT be undone. Please enter \"confirm\" to delete.");
		String confirmation = input.nextLine();
		if (confirmation.equals("confirm")) {
			try {
				udao.delete(workingUser);
				System.out.println("Employee deleted.");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Cancelling deletion.");
		}
	}

}
