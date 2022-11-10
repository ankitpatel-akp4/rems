/**
 * 
 */
package com.rems.bean;

/**
 * @author indicate0
 *
 */
public class Salary {
	private int pid;
	private int eid;
	private int worked_day;
	private int daily_wage;
	private int total;

	public Salary() {
		// TODO Auto-generated constructor stub
	}

	public Salary(int pid, int eid, int worked_day, int daily_wage) {
		super();
		this.pid = pid;
		this.eid = eid;
		this.worked_day = worked_day;
		this.daily_wage = daily_wage;
		this.total = worked_day * daily_wage;
	}

	@Override
	public String toString() {
		return "Project id: " + pid + "\nEmployee id: " + eid + "\nWork day=" + worked_day + "\nDaily wage="
				+ daily_wage + "\nTotal: " + total + "\n***********************************\n";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getWorked_day() {
		return worked_day;
	}

	public void setWorked_day(int worked_day) {
		this.worked_day = worked_day;
	}

	public int getDaily_wage() {
		return daily_wage;
	}

	public void setDaily_wage(int daily_wage) {
		this.daily_wage = daily_wage;
	}

	public int getTotal() {
		return worked_day * daily_wage;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
