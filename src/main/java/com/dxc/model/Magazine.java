package com.dxc.model;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="magazine")
public class Magazine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int floorno;
	private String shelfno;
	private String name;
	private LocalDate date;
	
	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Magazine(int id, int floorno, String shelfno, String name, LocalDate date) throws ParseException {
		super();
		this.id = id;
		this.floorno = floorno;
		this.shelfno = shelfno;
		this.name = name;
		this.date=date;
		
	}
	
	@Column(name="id",nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="floorno",nullable=false)
	public int getFloorno() {
		return floorno;
	}
	public void setFloorno(int floorno) {
		this.floorno = floorno;
	}
	@Column(name="shelfno",nullable=false)
	public String getShelfno() {
		return shelfno;
	}
	public void setShelfno(String shelfno) {
		this.shelfno = shelfno;
	}
	@Column(name="name",nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name ="date",nullable=false)
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		
		String strDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
		return "Newspaper [id=" + id + ",floorno=" + floorno + ", shelfno=" + shelfno + ", name=" + name + ", date=" + strDate + "]";
	}
	
}

