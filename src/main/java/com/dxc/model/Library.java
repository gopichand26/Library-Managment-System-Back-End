package com.dxc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="library")

public class Library {

	
	@Id
	@Column(name="floor_no")
	private int floor_no;
	
	@Column(name= "no_shelfs")
	private int no_shelfs;
	
	@Column(name= "no_books")
	private int no_books;
	
	@Column(name= "no_magazines")
	private int no_magazines;
	
	@Column(name= "no_newspapers")
	private int no_newspapers;

	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Library(int floor_no, int no_shelfs, int no_books, int no_magazines, int no_newspapers) {
		super();
		this.floor_no = floor_no;
		this.no_shelfs = no_shelfs;
		this.no_books = no_books;
		this.no_magazines = no_magazines;
		this.no_newspapers = no_newspapers;
	}

	public int getFloor_no() {
		return floor_no;
	}

	public void setFloor_no(int floor_no) {
		this.floor_no = floor_no;
	}

	public int getNo_shelfs() {
		return no_shelfs;
	}

	public void setNo_shelfs(int no_shelfs) {
		this.no_shelfs = no_shelfs;
	}

	public int getNo_books() {
		return no_books;
	}

	public void setNo_books(int no_books) {
		this.no_books = no_books;
	}

	public int getNo_magazines() {
		return no_magazines;
	}

	public void setNo_magazines(int no_magazines) {
		this.no_magazines = no_magazines;
	}

	public int getNo_newspapers() {
		return no_newspapers;
	}

	public void setNo_newspapers(int no_newspapers) {
		this.no_newspapers = no_newspapers;
	}

	@Override
	public String toString() {
		return "Library [floor_no=" + floor_no + ", no_shelfs=" + no_shelfs + ", no_books=" + no_books
				+ ", no_magazines=" + no_magazines + ", no_newspapers=" + no_newspapers + "]";
	}
	
	
	}