package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Registration {
	@Id
	private int Register_id;
	private String name;
	private String Address;
	private int Zipcode;
	private String counter;
	private String email;
	private String institution;
	private String sex;
	static int reg = 1000;
	private String date;
	private String time;
	// bank
	private double amount;
	private String curren;
	private String bankName;
	private String remark;
	private String transsactionalrefno;
	private String dateoftrans;

	public Registration() {

		DateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
		Date date = new Date();
		String a = (String) dateFormat.format(date);
		this.date = a;
		DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
		Date date1 = new Date();
		String c = (String) dateFormat1.format(date1);
		this.time = c;
		Register_id = ++reg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurren() {
		return curren;
	}

	public void setCurren(String curren) {
		this.curren = curren;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTranssactionalrefno() {
		return transsactionalrefno;
	}

	public void setTranssactionalrefno(String transsactionalrefno) {
		this.transsactionalrefno = transsactionalrefno;
	}

	public String getDateoftrans() {
		return dateoftrans;
	}

	public void setDateoftrans(String dateoftrans) {
		this.dateoftrans = dateoftrans;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getRegister_id() {
		return Register_id;
	}

	public void setRegister_id(int register_id) {
		Register_id = register_id;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getZipcode() {
		return Zipcode;
	}

	public void setZipcode(int zipcode) {
		Zipcode = zipcode;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

}
