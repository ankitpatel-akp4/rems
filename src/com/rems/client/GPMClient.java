/**
 * 
 */
package com.rems.client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.rems.bean.Employee;
import com.rems.bean.GPM;
import com.rems.bean.Salary;
import com.rems.dao.GPMDao;
import com.rems.dao.GPMDaoImp;
import com.rems.exception.AttendanceException;
import com.rems.exception.EmployeeException;
import com.rems.exception.GPMException;
import com.rems.exception.ProjectException;
import com.rems.exception.SalaryException;

/**
 * @author indicate0
 *
 */
public class GPMClient {
	void run() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter user id: ");
		int gid = scan.nextInt();
		System.out.println("Enter Password: ");
		String password = scan.next();

		GPMDao gd = new GPMDaoImp();
		try {
			GPM gpm = gd.login(gid, password);
			System.out.println("Welcome back - " + gpm.getGname());
			System.out.println("-----------------------------------------------------");
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

						int eid = 0;
						int egid = gpm.getGid();
						scan.nextLine();
						System.out.println("Enter employee name: ");
						String ename = scan.nextLine();
						System.out.println("Enter employee email: ");
						String eemail = scan.nextLine();
						System.out.println("Enter employee mobile: ");
						String emobile = scan.nextLine();
						System.out.println("Enter employee date of birth: (yyyy/mm/dd)");
						String edob = scan.nextLine();
						System.out.println("Enter employee registration date: (yyyy/mm/dd)");
						String e_registration_date = scan.nextLine();
						String gender;
						while (true) {
							System.out.println("Enter employee gender: (male, female, other)");
							gender = scan.nextLine();
							if (gender.toLowerCase().equals("male")) {
								break;
							} else if (gender.toLowerCase().equals("female")) {
								break;
							} else if (gender.toLowerCase().equals("other")) {
								break;
							} else {
								System.out.println("not a valid gender...");
							}
						}
						System.out.println("Enter employee aadhar no.: ");
						String aadhar = scan.nextLine();
						System.out.println("Enter employee bank acc. no.: ");
						String banck_account = scan.nextLine();
						System.out.println("Enter employee ifsc: ");
						String ifsc = scan.nextLine();

						try {
							String msg = gd.createEmployee(new Employee(eid, egid, ename, eemail, emobile, edob,
									e_registration_date, gender, aadhar, banck_account, ifsc));
							System.out.println(msg + "\n");
						} catch (EmployeeException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
							System.out.println(e.getMessage() + "\n");
						}

					} else if (key == 2) {
						try {
							List<Employee> projects = gd.viewAllEmployee();
							projects.forEach(System.out::println);
						} catch (EmployeeException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
							System.out.println(e.getMessage() + "\n");
						}
					} else if (key == 3) {
						try {
							System.out.println("Enter project id: ");
							int pid = scan.nextInt();
							System.out.println("Enter employee id: ");
							int eid = scan.nextInt();
							System.out.println("Enter employee daily wage: ");
							int daily_wage = scan.nextInt();
							String msg = gd.assignEmoloyeeToProject(pid, eid, daily_wage);
							System.out.println(msg);
						} catch (EmployeeException | ProjectException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
							System.out.println(e.getMessage() + "\n");
						}
					} else if (key == 4) {
						System.out.println("Enter project id: ");
						int pid = scan.nextInt();
						System.out.println("Enter employee id: ");
						int eid = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter date: (yyyy/mm/dd)");
						String date = scan.nextLine();
						System.out.println("Enter 1 for present, 0 for absent: ");
						int present_absent = scan.nextInt();
						scan.nextLine();
						try {
							String msg = gd.attendence(pid, eid, date, present_absent);
							System.out.println(msg);
						} catch (AttendanceException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
							System.out.println(e.getMessage() + "\n");
						}
					} else if (key == 5) {

						try {
							System.out.println("Enter project id: ");
							List<Salary> salaries = gd.contributionOfEmployee(scan.nextInt());
							salaries.forEach(System.out::println);
						} catch (SalaryException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
							System.out.println(e.getMessage() + "\n");
						}
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
