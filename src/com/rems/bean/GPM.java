/**
 * 
 */
package com.rems.bean;

/**
 * @author indicate0
 *
 */
public class GPM {
	private int gid;
	private int gbid;
	private String gname;
	private String gemail;
	private String gmobile;
	private String gpin_code;

	public GPM() {

	}

	public GPM(int gid, int gbid, String gname, String gemail, String gmobile, String gpin_code) {
		super();
		this.gid = gid;
		this.gbid = gbid;
		this.gname = gname;
		this.gemail = gemail;
		this.gmobile = gmobile;
		this.gpin_code = gpin_code;
	}

	@Override
	public String toString() {
		return "GPM id: " + gid + "\nBDO id: " + gbid + "\nGPM name: " + gname + "\nGPM email=" + gemail
				+ "\nGPM mobile: " + gmobile + "\nGP pin code: " + gpin_code + "\n*****************************\n";
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getGbid() {
		return gbid;
	}

	public void setGbid(int gbid) {
		this.gbid = gbid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGemail() {
		return gemail;
	}

	public void setGemail(String gemail) {
		this.gemail = gemail;
	}

	public String getGmobile() {
		return gmobile;
	}

	public void setGmobile(String gmobile) {
		this.gmobile = gmobile;
	}

	public String getGpin_code() {
		return gpin_code;
	}

	public void setGpin_code(String gpin_code) {
		this.gpin_code = gpin_code;
	}

}
