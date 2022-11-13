/**
 * 
 */
package com.rems.client;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author indicate0
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("!! WELCOME TO REMS !!");
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("\nEnter...");
				System.out.println("1 to login as BDO.");
				System.out.println("2 to login as GPM.");
				System.out.println("0 to exit");
				int key = scan.nextInt();
				if (key == 0) {
					System.out.println("Thank you for using REMS...!");
					break;
				} else if (key == 1) {
					new BDOClient().run();
				} else if (key == 2) {
					new GPMClient().run();
				} else {
					System.out.println("Please Enter a valid number...\n");
				}

			} catch (InputMismatchException e) {
				System.out.println("Please Enter a valid input...\n");
				scan = new Scanner(System.in);
			} catch (Exception e) {
				System.out.println(e.getMessage() + "\n");

			}
		}

	}

}
