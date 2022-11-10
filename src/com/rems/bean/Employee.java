/**
 * 
 */
package com.rems.bean;

/**
 * @author indicate0
 *
 */
public class Employee {
	private int eid;
	private int egid;
	private String ename;
	private String eemail;
	private String emobile;
	private String edob;
	private String e_registration_date;
	private String gender;
	private String aadhar;
	private String banck_account;
	private String ifsc;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, int egid, String ename, String eemail, String emobile, String edob,
			String e_registration_date, String gender, String aadhar, String banck_account, String ifsc) {
		super();
		this.eid = eid;
		this.egid = egid;
		this.ename = ename;
		this.eemail = eemail;
		this.emobile = emobile;
		this.edob = edob;
		this.e_registration_date = e_registration_date;
		this.gender = gender;
		this.aadhar = aadhar;
		this.banck_account = banck_account;
		this.ifsc = ifsc;
	}

	@Override
	public String toString() {
		return "Employee id= " + eid + "\nGPM id= " + egid + "\nName= " + ename + "\nEmail= " + eemail + "\nMobile= "
				+ emobile + "\ndob= " + edob + "\nRestration date= " + e_registration_date + "\nGender= " + gender
				+ "\nAadhar no= " + aadhar + "\nBanck account= " + banck_account + "\nIFSC= " + ifsc
				+ "\n**************************\n";
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getEgid() {
		return egid;
	}

	public void setEgid(int egid) {
		this.egid = egid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEemail() {
		return eemail;
	}

	public void setEemail(String eemail) {
		this.eemail = eemail;
	}

	public String getEmobile() {
		return emobile;
	}

	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}

	public String getEdob() {
		return edob;
	}

	public void setEdob(String edob) {
		this.edob = edob;
	}

	public String getE_registration_date() {
		return e_registration_date;
	}

	public void setE_registration_date(String e_registration_date) {
		this.e_registration_date = e_registration_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getBanck_account() {
		return banck_account;
	}

	public void setBanck_account(String banck_account) {
		this.banck_account = banck_account;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

}
