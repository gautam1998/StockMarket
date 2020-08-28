package com.stockmarket.upload.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StockPrice")
public class StockPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "companyname")
	private String companyname;
	
	@Column(name = "stockexchange")
	private String stockexchange;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
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

	public StockPrice(long id, String companyname, String stockexchange, long price, String date, String time) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.stockexchange = stockexchange;
		this.price = price;
		this.date = date;
		this.time = time;
	}

	public StockPrice() {
		super();
	}
	
	
	
}
