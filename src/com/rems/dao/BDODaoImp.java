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
import java.util.Scanner;

import com.rems.bean.BDO;
import com.rems.bean.GPM;
import com.rems.bean.Project;
import com.rems.bean.Salary;
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
		String msg = null;
		try (Connection conn = DBConnection.getDBConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"insert into project (pbid,pname, pdescription, budget, pstart_date,pexpected_end_date) values (?,?,?,?,?,?)");
			ps.setInt(1, project.getPbid());
			ps.setString(2, project.getPname());
			ps.setString(3, project.getPdescription());
			ps.setInt(4, project.getBudget());
			ps.setString(5, project.getPstart_date());
			ps.setString(6, project.getPexpected_end_date());
			int res = ps.executeUpdate();
			if (res > 0) {
				msg = "Project created successfully....";

			} else {
				throw new ProjectException("Opps... something went wrong!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProjectException(e.getMessage());
		}

		return msg;
	}

	@Override
	public List<Project> viewProjects() throws ProjectException {
		List<Project> projects = new ArrayList<>();
		try (Connection conn = DBConnection.getDBConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from project");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				projects.add(new Project(rs.getInt(1), rs.getInt(2), rs.getInt(10), rs.getString(3), rs.getString(3),
						rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
			}
			if (projects.size() < 0) {
				throw new ProjectException("Opps... no project is added yet");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProjectException(e.getMessage());
		}

		return projects;
	}

	@Override
	public String createGPM(GPM gpm) throws GPMException {
		String msg = null;
		try (Connection conn = DBConnection.getDBConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("insert into gpm (gbid,gname,gemail,gmobile,gpin_code) values (?,?,?,?,?)");
			ps.setInt(1, gpm.getGbid());
			ps.setString(2, gpm.getGname());
			ps.setString(3, gpm.getGemail());
			ps.setString(4, gpm.getGmobile());
			ps.setString(5, gpm.getGpin_code());
			int res = ps.executeUpdate();

			if (res > 0) {
				msg = "GPM created successfully....";
				PreparedStatement ps1 = conn.prepareStatement(
						"select gid from gpm where gbid=? and gname=? and gemail=? and gmobile=? and gpin_code=?");
				ps1.setInt(1, gpm.getGbid());
				ps1.setString(2, gpm.getGname());
				ps1.setString(3, gpm.getGemail());
				ps1.setString(4, gpm.getGmobile());
				ps1.setString(5, gpm.getGpin_code());
				ResultSet res1 = ps1.executeQuery();
				if (res1.next()) {
					PreparedStatement ps2 = conn.prepareStatement("insert into users values (?,'gpm',?)");
					ps2.setInt(1, res1.getInt(1));
					Scanner scan = new Scanner(System.in);
					System.out.println("Enter password of gpm: ");
					ps2.setString(2, scan.nextLine());
					int res2 = ps2.executeUpdate();
					if (res2 > 0)
						System.out.println("Successfully added to users table...");
					else
						System.out.println("But, not add to users table for login, yet");
				} else {
					System.out.println("But, not add to users table for login, yet");
				}

			} else {
				throw new GPMException("Opps... something went wrong!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GPMException(e.getMessage());
		}

		return msg;
	}

	@Override
	public List<GPM> viewGPM() throws GPMException {
		List<GPM> gpms = new ArrayList<>();
		try (Connection conn = DBConnection.getDBConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from gpm");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				gpms.add(new GPM(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));
			}
			if (gpms.size() < 0) {
				throw new GPMException("Opps... no project is added yet");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new GPMException(e.getMessage());
		}

		return gpms;
	}

	@Override
	public String allocateProjectToGPM(int gid, int pid) throws GPMException, ProjectException {
		String msg = null;
		try (Connection conn = DBConnection.getDBConnection()) {
			PreparedStatement ps = conn.prepareStatement("update project set pgid=? where pid=?");
			ps.setInt(1, gid);
			ps.setInt(2, pid);
			int res = ps.executeUpdate();
			if (res > 0) {
				msg = "Project " + pid + " successfully assigned to GPM " + gid;

			} else {
				throw new ProjectException("Opps... something went wrong!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProjectException(e.getMessage());
		}

		return msg;
	}

	@Override
	public List<Salary> viewProjectEmployee(int pid) throws ProjectException, EmployeeException {

		return null;

	}

	@Override
	public String updateDateAmount(int pid, String date, int amount) throws ProjectException {
		String msg = null;
		try (Connection conn = DBConnection.getDBConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("update project set pend_date=?,total_amount_expended=? where pid=?");
			ps.setString(1, date);
			ps.setInt(2, amount);
			ps.setInt(3, pid);
			int res = ps.executeUpdate();
			if (res > 0) {
				msg = "successfully updated....";

			} else {
				throw new ProjectException("Opps... something went wrong!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProjectException(e.getMessage());
		}

		return msg;
	}

}
