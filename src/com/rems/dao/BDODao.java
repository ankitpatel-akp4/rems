/**
 * 
 */
package com.rems.dao;

import java.util.List;

import com.rems.bean.BDO;
import com.rems.bean.GPM;
import com.rems.bean.Project;
import com.rems.bean.Salary;
import com.rems.exception.BDOException;
import com.rems.exception.EmployeeException;
import com.rems.exception.GPMException;
import com.rems.exception.ProjectException;

/**
 * @author indicate0
 *
 */
public interface BDODao {
	public BDO login(int bid, String password) throws BDOException;

	public String creatProject(Project project) throws ProjectException;

	public List<Project> viewProjects() throws ProjectException;

	public String createGPM(GPM gpm) throws GPMException;

	public List<GPM> viewGPM() throws GPMException;

	public String allocateProjectToGPM(int gid, int pid) throws GPMException, ProjectException;

	public List<Salary> viewProjectEmployee(int pid) throws ProjectException, EmployeeException;

	public String updateDateAmount(int pid, String date, int amount) throws ProjectException;
}
