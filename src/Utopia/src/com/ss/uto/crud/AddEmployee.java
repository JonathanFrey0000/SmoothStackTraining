/**
 * 
 */
package com.ss.uto.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.UserDAO;
import com.ss.uto.dao.UserRoleDAO;
import com.ss.uto.entities.User;
import com.ss.uto.entities.UserRole;

/**
 * @author Jonathan Frey
 *
 */
public class AddEmployee implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		UserDAO adao = new UserDAO(conn);
		User workingUser = new User();

		Scanner input = new Scanner(System.in);

		System.out.println(
				"Please enter the following information for the Employee.\nEnter a blank line at any time to cancel.");
		System.out.print("Given name: ");
		String gName = input.nextLine();
		workingUser.setGivenName(gName);
		System.out.print("Family name: ");
		String fName = input.nextLine();
		workingUser.setFamilyName(fName);
		System.out.print("Username: ");
		String uName = input.nextLine();
		workingUser.setUsername(uName);
		System.out.print("Email: ");
		String email = input.nextLine();
		workingUser.setEmail(email);
		System.out.print("Password: ");
		String pass = input.nextLine();
		workingUser.setPassword(pass);
		System.out.print("Phone: ");
		String phone = input.nextLine();
		workingUser.setPhone(phone);
		Integer role_id = 1;
		
		UserRoleDAO urdao = new UserRoleDAO(conn);
		UserRole role;

		try {
			role = urdao.getData("select * from user_role where id = ?", role_id).get(0);
			workingUser.setRole(role);
			adao.add(workingUser);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
