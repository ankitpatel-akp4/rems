/**
 * 
 */
package com.rems.dao;

import java.util.List;

import com.rems.bean.Employee;
import com.rems.bean.GPM;
import com.rems.bean.Salary;
import com.rems.exception.AttendanceException;
import com.rems.exception.EmployeeException;
import com.rems.exception.GPMException;
import com.rems.exception.ProjectException;
import com.rems.exception.SalaryException;

/**
 * @author indicate0
 *
 */
public interface GPMDao {
	public GPM login(int gid, String password) throws GPMException;

	public String createEmployee(Employee emp) throws EmployeeException;

	public List<Employee> viewAllEmployee() throws EmployeeException;

	public String assignEmoloyeeToProject(int pid, int eid, int daily_wage) throws EmployeeException, ProjectException;

	public String attendence(String date) throws AttendanceException;

	public List<Salary> contributionOfEmployee() throws SalaryException;
}
