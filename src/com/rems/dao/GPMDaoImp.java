/**
 * 
 */
package com.rems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rems.bean.Employee;
import com.rems.bean.GPM;
import com.rems.bean.Salary;
import com.rems.exception.AttendanceException;
import com.rems.exception.EmployeeException;
import com.rems.exception.GPMException;
import com.rems.exception.ProjectException;
import com.rems.exception.SalaryException;
import com.rems.util.DBUtil;

/**
 * @author indicate0
 *
 */
public class GPMDaoImp implements GPMDao {

	@Override
	public GPM login(int gid, String password) throws GPMException {
		GPM gpm = null;
		try (Connection conn = DBUtil.getDBConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("select * from users where uid=? and did='gpm' and password=?");
			ps.setInt(1, gid);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Statement st = conn.createStatement();
				ResultSet rs1 = st.executeQuery("select * from gpm where gid=" + gid);
				if (rs1.next()) {
					gpm = new GPM(rs1.getInt(1), rs1.getInt(2), rs1.getString(3), rs1.getString(4), rs1.getString(5),
							rs1.getString(6));
				} else {
					throw new GPMException("Opps... Invalid credentials!");
				}

			} else {
				throw new GPMException("Opps... Invalid credentials!");
			}

		} catch (SQLException e) {
//			e.printStackTrace();
			throw new GPMException(e.getMessage());
		}

		return gpm;
	}

	@Override
	public String createEmployee(Employee emp) throws EmployeeException {
		String msg = null;
		try (Connection conn = DBUtil.getDBConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"insert into employee (gid, ename, eemail, emobile, edob, e_registration_date, gender, aadhar, bank_account, ifsc) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, emp.getEgid());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getEemail());
			ps.setString(4, emp.getEmobile());
			ps.setString(5, emp.getEdob());
			ps.setString(6, emp.getE_registration_date());
			ps.setString(7, emp.getGender());
			ps.setString(8, emp.getAadhar());
			ps.setString(9, emp.getBanck_account());
			ps.setString(10, emp.getIfsc());
			int res = ps.executeUpdate();
			if (res > 0) {
				msg = "Employee created successfully....";

			} else {
				throw new EmployeeException("Opps... something went wrong!");
			}

		} catch (SQLException e) {
//			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}

		return msg;
	}

	@Override
	public List<Employee> viewAllEmployee() throws EmployeeException {
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = DBUtil.getDBConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11)));
			}
			if (employees.size() <= 0) {
				throw new EmployeeException("Opps... no project is added yet");
			}

		} catch (SQLException e) {
//			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}

		return employees;
	}

	@Override
	public String assignEmoloyeeToProject(int pid, int eid, int daily_wage) throws EmployeeException, ProjectException {
		String msg = null;
		try (Connection conn = DBUtil.getDBConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into project_employee_payment values(?,?,?)");
			ps.setInt(1, pid);
			ps.setInt(2, eid);
			ps.setInt(3, daily_wage);
			int res = ps.executeUpdate();
			if (res > 0) {
				msg = "Employee " + eid + " successfully assigned to project " + pid;

			} else {
				throw new ProjectException("Opps... something is wrong with employee table or project table!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProjectException(e.getMessage());
		}

		return msg;
	}

	@Override
	public String attendence(int pid, int eid, String date, int present_absent) throws AttendanceException {

		String msg = null;
		try (Connection conn = DBUtil.getDBConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into attendance values(?,?,?,?)");
			ps.setInt(1, pid);
			ps.setInt(2, eid);
			ps.setString(3, date);
			ps.setInt(4, present_absent);
			int res = ps.executeUpdate();
			if (res > 0) {
				msg = "Operation successful...";

			} else {
				throw new AttendanceException(
						"Opps... something is wrong! make sure employee id and project id is valid...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AttendanceException(e.getMessage());
		}

		return msg;
	}

	@Override
	public List<Salary> contributionOfEmployee(int pid) throws SalaryException {
		List<Salary> salaries = new ArrayList<>();
		try (Connection conn = DBUtil.getDBConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"select p.pid, p.eid, count(p.eid), daily_wage from project_employee_payment p inner join attendance a on p.pid=a.pid and p.eid=a.eid where a.pid=? and present_absent=1 group by p.pid, p.eid, daily_wage order by p.pid, p.eid");
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				salaries.add(new Salary(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
			if (salaries.size() <= 0) {
				throw new SalaryException("Opps... couldn't find any record...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SalaryException(e.getMessage());
		}

		return salaries;
	}

}
