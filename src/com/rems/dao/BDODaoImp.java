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

import com.rems.bean.BDO;
import com.rems.bean.Employee;
import com.rems.bean.GPM;
import com.rems.bean.Project;
import com.rems.exception.BDOException;
import com.rems.exception.EmployeeException;
import com.rems.exception.GPMException;
import com.rems.exception.ProjectException;
import com.rems.util.DBConnection;

/**
 * @author indicate0
 *
 */
public class BDODaoImp implements BDODao {

	@Override
	public BDO login(int bid, String password) throws BDOException {
		BDO bdo = null;
		try (Connection conn = DBConnection.getDBConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("select * from users where uid=? and did='bdo' and password=?");
			ps.setInt(1, bid);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Statement st = conn.createStatement();
				ResultSet data = st.executeQuery("select * from bdo where bid=" + bid);
				if (data.next()) {
					bdo = new BDO(data.getInt(1), data.getString(2), data.getString(3), data.getString(4),
							data.getString(5), data.getString(6));
				} else {
					throw new BDOException("Opps... Invalid credentials!");
				}

			} else {
				throw new BDOException("Opps... Invalid credentials!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDOException(e.getMessage());
		}

		return bdo;
	}

	@Override
	public String creatProject(Project project) throws ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> viewProjects() throws ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createGPM(GPM gpm) throws GPMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GPM> viewGPM() throws GPMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String allocateProjectToGPM(int gid, int pid) throws GPMException, ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> viewProjectEmployee(int pid) throws ProjectException, EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

}
