package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class accummodate 
{
	@Id

	@Column(name = "accum_id", updatable = false, nullable = false)
	private String accum_id;
	private String email;
	private int Register_id;
	private String date;
	private String time;
	// bank
		private double amount;
		private String curren;
		private String bankName;
		private String transsactionalrefno;
		private String dateoftrans;
		
		
		
		public String getAccum_id() {
			return accum_id;
		}

		public void setAccum_id(String accum_id) {
			this.accum_id = accum_id;
		}

		public accummodate() {
			this.accum_id="accum" + UUID.randomUUID().toString().substring(30).toUpperCase();
			DateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
			Date date = new Date();
			String a = (String) dateFormat.format(date);
			this.date = a;
			DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
			Date date1 = new Date();
			String c = (String) dateFormat1.format(date1);
			this.time = c;
			
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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
		
		
		public String getTranssactionalrefno() {
			return transsactionalrefno;
		}

		public void setRegister_id(int register_id) {
			Register_id = register_id;
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

		public int getRegister_id() {
			return Register_id;
		}
		
	  	
}
