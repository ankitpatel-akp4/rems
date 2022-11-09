/**
 * 
 */
package com.rems.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.rems.bean.GPM;
import com.rems.dao.GPMDao;
import com.rems.dao.GPMDaoImp;
import com.rems.exception.GPMException;

/**
 * @author indicate0
 *
 */
public class GPMClient {
	void run() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter user id: ");
		int bid = scan.nextInt();
		System.out.println("Enter Password: ");
		String password = scan.next();

		GPMDao gd = new GPMDaoImp();
		try {
			GPM gpm = gd.login(bid, password);
			System.out.println("Welcome back - " + gpm.getGname());
			while (true) {
				try {
					System.out.println("Enter...");
					System.out.println("1 to create an employee.");
					System.out.println("2 to view all employees.");
					System.out.println("3 to assign an emoloyee to a project.");
					System.out.println("4 to give attendence.");
					System.out.println("5 to know the contribution of employees.");
					System.out.println("0 to exit");
					int key = scan.nextInt();
					if (key == 0) {
						break;
					} else if (key == 1) {

					} else if (key == 2) {

					} else if (key == 3) {

					} else if (key == 4) {

					} else if (key == 5) {

					} else {
						System.out.println("Please Enter a valid number...\n");
					}

				} catch (InputMismatchException e) {
//					System.out.println(e);
					System.out.println("Please Enter a valid input...\n");
					scan = new Scanner(System.in);
				}
			}

		} catch (GPMException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
