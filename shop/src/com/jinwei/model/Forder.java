package com.jinwei.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Forder entity. @author MyEclipse Persistence Tools
 */

public class Forder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String phone;
	private String remark;
	private Timestamp date;
	private double total;
	private String post;
	private String address;
	private User user;
	private Status status;
	private Set<Sorder> sorderSet;
	
	
	

	// Constructors

	

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}


	public Forder(Set<Sorder> sorderSet) {
		super();
		this.sorderSet = sorderSet;
	}

	public Set<Sorder> getSorderSet() {
		return sorderSet;
	}

	public void setSorderSet(Set<Sorder> sorderSet) {
		this.sorderSet = sorderSet;
	}

	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	/** default constructor */
	public Forder() {
	}

	/** minimal constructor */
	public Forder(Timestamp date) {
		this.date = date;
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	

	

	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}