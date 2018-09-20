package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PaperUplode implements Serializable
{
	@Id
	private String paper_id;
	private String title;
	private String description;
	private int register_id;
	private String date;
	private String time;
	private String name;
	private String location=null;
	private String filename=null;
	private String status="Painding";
    public PaperUplode() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
		Date date = new Date();
		String a = (String) dateFormat.format(date);
		this.date = a;
		DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
		Date date1 = new Date();
		String c = (String) dateFormat1.format(date1);
		this.time = c;
		this.paper_id ="Paper"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    

	public int getRegister_id() {
		return register_id;
	}

	public void setRegister_id(int register_id) {
		this.register_id = register_id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

}
