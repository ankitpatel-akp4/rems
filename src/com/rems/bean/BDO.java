/**
 * 
 */
package com.rems.bean;

/**
 * @author indicate0
 *
 */
public class BDO {
	private int bid;
	private String bname;
	private String bemail;
	private String bpin_code;
	private String district;
	private String state;

	public BDO() {
		// TODO Auto-generated constructor stub
	}

	public BDO(int bid, String bname, String bemail, String bpin_code, String district, String state) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bemail = bemail;
		this.bpin_code = bpin_code;
		this.district = district;
		this.state = state;
	}

	@Override
	public String toString() {
		return "BDO [bid=" + bid + ", bname=" + bname + ", bemail=" + bemail + ", bpin_code=" + bpin_code
				+ ", district=" + district + ", state=" + state + "]";
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}

	public String getBpin_code() {
		return bpin_code;
	}

	public void setBpin_code(String bpin_code) {
		this.bpin_code = bpin_code;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
