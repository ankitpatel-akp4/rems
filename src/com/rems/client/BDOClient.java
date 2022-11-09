package com.rems.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.rems.bean.BDO;
import com.rems.dao.BDODao;
import com.rems.dao.BDODaoImp;
import com.rems.exception.BDOException;

public class BDOClient {
	void run() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter user id: ");
		int bid = scan.nextInt();
		System.out.println("Enter Password: ");
		String password = scan.next();
		BDODao bd = new BDODaoImp();
		try {
			BDO bdo = bd.login(bid, password);
			System.out.println("Welcome back - " + bdo.getBname());
			System.out.println("-----------------------------------------------------");
			while (true) {
				try {
					System.out.println("Enter...");
					System.out.println("1 to create a project.");
					System.out.println("2 to view all projects");
					System.out.println("3 to create a GPM.");
					System.out.println("4 to view GPMs.");
					System.out.println("5 to allocate project to GPM.");
					System.out.println("6 to view a project's employees");
					System.out.println("0 to exit");
					int key = scan.nextInt();
					if (key == 0) {
						break;
					} else if (key == 1) {

					} else if (key == 2) {

					} else if (key == 3) {

					} else if (key == 4) {

					} else if (key == 5) {

					} else if (key == 6) {

					} else {
						System.out.println("Please Enter a valid number...\n");
					}

				} catch (InputMismatchException e) {
//					System.out.println(e);
					System.out.println("Please Enter a valid input...\n");
					scan = new Scanner(System.in);
				}
			}

		} catch (BDOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
