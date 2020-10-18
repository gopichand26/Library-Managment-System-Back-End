package com.dxc.model;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	@Column(name = "Name")
	String name;
	@Column(name = "Mobile")
	String mobile;
	@Column(name = "Date")
	LocalDate date;
	@Column(name = "In_Time")
	LocalTime intime;
	@Column(name = "Out_Time")
	LocalTime outtime;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(int id, String name, String mobile, LocalDate date, String intime, String outtime) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.date = date;
		LocalTime time = LocalTime.parse(intime);
		this.intime = time;
		LocalTime timeo = LocalTime.parse(intime);
		this.outtime = timeo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getIntime() {
		return intime;
	}

	public void setIntime(LocalTime intime) {
		this.intime = intime;
	}

	public LocalTime getOuttime() {
		return outtime;
	}

	public void setOuttime(LocalTime outtime) {
		this.outtime = outtime;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", mobile=" + mobile + ", date=" + date + ", intime=" + intime
				+ ", outtime=" + outtime + "]";
	}

}

