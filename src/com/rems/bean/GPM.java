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
	private String gmobil;
	private String gpin_code;

	public GPM() {

	}

	public GPM(int gid, int gbid, String gname, String gemail, String gmobil, String gpin_code) {
		super();
		this.gid = gid;
		this.gbid = gbid;
		this.gname = gname;
		this.gemail = gemail;
		this.gmobil = gmobil;
		this.gpin_code = gpin_code;
	}

	@Override
	public String toString() {
		return "GPM [gid=" + gid + ", gbid=" + gbid + ", gname=" + gname + ", gemail=" + gemail + ", gmobil=" + gmobil
				+ ", gpin_code=" + gpin_code + "]";
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

	public String getGmobil() {
		return gmobil;
	}

	public void setGmobil(String gmobil) {
		this.gmobil = gmobil;
	}

	public String getGpin_code() {
		return gpin_code;
	}

	public void setGpin_code(String gpin_code) {
		this.gpin_code = gpin_code;
	}

}
