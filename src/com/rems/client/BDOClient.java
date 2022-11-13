package com.rems.client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.rems.bean.BDO;
import com.rems.bean.GPM;
import com.rems.bean.Project;
import com.rems.dao.BDODao;
import com.rems.dao.BDODaoImp;
import com.rems.dao.GPMDaoImp;
import com.rems.exception.BDOException;
import com.rems.exception.GPMException;
import com.rems.exception.ProjectException;
import com.rems.exception.SalaryException;

public class BDOClient {
	void run() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter user id: ");
		int bid = scan.nextInt();
		System.out.println("Enter Password: ");
		String password = scan.next();
		BDODao bd = new BDODaoImp();
		BDO bdo = null;
		boolean session = true;
		try {
			bdo = bd.login(bid, password);
			System.out.println("Welcome back - " + bdo.getBname());
			System.out.println("-----------------------------------------------------");
		} catch (BDOException e) {
//			e.printStackTrace();
			session = false;
			System.out.println(e.getMessage() + "\n");
		}
		while (session) {
			try {
				System.out.println("\nEnter...");
				System.out.println("1 to create a project.");
				System.out.println("2 to view all projects.");
				System.out.println("3 to create a GPM.");
				System.out.println("4 to view GPMs.");
				System.out.println("5 to allocate project to GPM.");
				System.out.println("6 to view a project's employees status.");
				System.out.println("7 to update total amount expended and end date of a project.");
				System.out.println("0 to log out");
				int key = scan.nextInt();
				scan.nextLine();
				if (key == 0) {
					break;
				} else if (key == 1) {
//	create a project
					System.out.println("Enter project name: ");
					String pname = scan.nextLine();
					System.out.println("Enter description: ");
					String pdescription = scan.nextLine();
					System.out.println("Enter budget: ");
					int budget = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter start date of the project: (yyyy/mm/dd)");
					String pstart_date = scan.nextLine();
					System.out.println("Enter expected end date of the project: (yyyy/mm/dd)");
					String pexpected_end_date = scan.nextLine();
					String msg = bd.creatProject(new Project(0, 0, bdo.getBid(), pname, pdescription, budget,
							pstart_date, pexpected_end_date, null, 0));
					System.out.println(msg + "\n");

				} else if (key == 2) {
//	 view all projects
					List<Project> projects = bd.viewProjects();
					projects.forEach(System.out::println);

				} else if (key == 3) {
//	create a GPM
					System.out.println("Enter GPM name: ");
					String gname = scan.nextLine();
					System.out.println("Enter email: ");
					String gemail = scan.nextLine();
					System.out.println("Enter mobile: ");
					String gmobile = scan.nextLine();
					System.out.println("Enter pin code: ");
					String gpin_code = scan.nextLine();
					String msg = bd.createGPM(new GPM(0, bdo.getBid(), gname, gemail, gmobile, gpin_code));
					System.out.println(msg + "\n");

				} else if (key == 4) {
// view GPMs
					List<GPM> gpms = bd.viewGPM();
					gpms.forEach(System.out::println);

				} else if (key == 5) {
//	allocate project to GPM
					System.out.println("Enter GMP id: ");
					int gid = scan.nextInt();
					System.out.println("Enter project id: ");
					int pid = scan.nextInt();
					String msg = bd.allocateProjectToGPM(gid, pid);
					System.out.println(msg);

				} else if (key == 6) {
//	view a project's employees status
					System.out.println("Enter project id: ");
					int pid = scan.nextInt();
					new GPMDaoImp().contributionOfEmployee(pid).forEach(System.out::println);

				} else if (key == 7) {
//	update total amount expended and end date of a project
					System.out.println("Enter project id: ");
					int pid = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter end date: ");
					String date = scan.nextLine();
					System.out.println("Enter total amount: ");
					int amount = scan.nextInt();
					String msg = bd.updateDateAmount(pid, date, amount);
					System.out.println(msg);

				} else {
					System.out.println("Please Enter a valid number...\n");
				}

			} catch (InputMismatchException e) {
//					System.out.println(e);
				System.out.println("Please Enter a valid input...\n");
				scan = new Scanner(System.in);

			} catch (GPMException | SalaryException | ProjectException e) {
				System.out.println(e.getMessage() + "\n");
			} catch (Exception e) {
				System.out.println(e.getMessage() + "\n");

			}
		}

	}
}
