package com.jinwei.model;

/**
 * Sorder entity. @author MyEclipse Persistence Tools
 * 当对象存储到硬盘的时候就需要实现序列化接口 序列化的功能就是添加了一个唯一的ID
 * 这样在反序列化的时候就可以成功的找到相应的对象
 * 
 * 容器的关闭并不会导致 session的销毁
 */

public class Sorder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Double price;
	private Integer number;
	private Product product;
	private Forder forder;

	// Constructors

	public Forder getForder() {
		return forder;
	}


	public void setForder(Forder forder) {
		this.forder = forder;
	}


	/** default constructor */
	public Sorder() {
	}


	// Property accessors

	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


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

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}


}