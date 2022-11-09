/**
 * 
 */
package com.rems.bean;

/**
 * @author indicate0
 *
 */
public class Salary {
	private int worked_day;
	private int daily_wage;
	private int total;

	public Salary() {
		// TODO Auto-generated constructor stub
	}

	public Salary(int worked_day, int daily_wage) {
		super();
		this.worked_day = worked_day;
		this.daily_wage = daily_wage;
		this.total = worked_day * daily_wage;
	}

	@Override
	public String toString() {
		return "Salary [worked_day=" + worked_day + ", daily_wage=" + daily_wage + ", total=" + total + "]";
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
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
