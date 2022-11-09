/**
 * 
 */
package com.rems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.rems.bean.Employee;
import com.rems.bean.GPM;
import com.rems.bean.Salary;
import com.rems.exception.AttendanceException;
import com.rems.exception.EmployeeException;
import com.rems.exception.GPMException;
import com.rems.exception.ProjectException;
import com.rems.exception.SalaryException;
import com.rems.util.DBConnection;

/**
 * @author indicate0
 *
 */
public class GPMDaoImp implements GPMDao {

	@Override
	public GPM login(int gid, String password) throws GPMException {
		GPM gpm = null;
		try (Connection conn = DBConnection.getDBConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("select * from users where uid=? and did='gpm' and password=?");
			ps.setInt(1, gid);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Statement st = conn.createStatement();
				ResultSet rs1 = st.executeQuery("select * from bdo where gid=" + gid);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> viewAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignEmoloyeeToProject(int pid, int eid, int daily_wage) throws EmployeeException, ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String attendence(String date) throws AttendanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salary> contributionOfEmployee() throws SalaryException {
		// TODO Auto-generated method stub
		return null;
	}

}
