package com.rems.bean;

public class Project {
	private int pid;
	private int pgid;
	private String pname;
	private String pdescription;
	private int budget;
	private String pstart_date;
	private String pexpected_end_date;
	private String pend_date;
	private int total_amount_expended;

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int pid, int pgid, String pname, String pdescription, int budget, String pstart_date,
			String pexpected_end_date, String pend_date, int total_amount_expended) {
		super();
		this.pid = pid;
		this.pgid = pgid;
		this.pname = pname;
		this.pdescription = pdescription;
		this.budget = budget;
		this.pstart_date = pstart_date;
		this.pexpected_end_date = pexpected_end_date;
		this.pend_date = pend_date;
		this.total_amount_expended = total_amount_expended;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pgid=" + pgid + ",  pname=" + pname + ", pdescription=" + pdescription
				+ ", budget=" + budget + ", pstart_date=" + pstart_date + ", pexpected_end_date=" + pexpected_end_date
				+ ", pend_date=" + pend_date + ", total_amount_expended=" + total_amount_expended + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPgid() {
		return pgid;
	}

	public void setPgid(int pgid) {
		this.pgid = pgid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getPstart_date() {
		return pstart_date;
	}

	public void setPstart_date(String pstart_date) {
		this.pstart_date = pstart_date;
	}

	public String getPexpected_end_date() {
		return pexpected_end_date;
	}

	public void setPexpected_end_date(String pexpected_end_date) {
		this.pexpected_end_date = pexpected_end_date;
	}

	public String getPend_date() {
		return pend_date;
	}

	public void setPend_date(String pend_date) {
		this.pend_date = pend_date;
	}

	public int getTotal_amount_expended() {
		return total_amount_expended;
	}

	public void setTotal_amount_expended(int total_amount_expended) {
		this.total_amount_expended = total_amount_expended;
	}
}
