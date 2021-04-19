package com.ss.uto.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.service.AdministratorService;
import com.ss.uto.service.EmployeeService;
import com.ss.uto.service.TravelerService;

/**
 * @author Jonathan Frey
 *
 */
public class Driver {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner input = new Scanner(System.in);
		Integer choice;

		EmployeeService employee = new EmployeeService();
		AdministratorService admin = new AdministratorService();
		TravelerService traveler = new TravelerService();
		
		boolean done = true;
		do {
			System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you?"
					+ "\n1) Employee" + "\n2) Administrator" + "\n3) Traveler");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				employee.employeeMenuOne();
				break;
			case 2:
				admin.mainAdminMenu();
				break;
			case 3:
				traveler.menuOne();
				break;
			default:
				done = false;
			}
		} while (done);
		
		input.close();

	}

}
