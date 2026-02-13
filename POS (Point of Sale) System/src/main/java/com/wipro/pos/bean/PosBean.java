package com.wipro.pos.bean;

import java.util.Date;

public class PosBean {
	 private String transId;
	private String customerName;
	 private String itemName;
	 private Date transDate;
	private int quantity;
	private double price;
	 private double totalAmount;
	private String remarks;
	public PosBean(String transId, String customerName, String itemName, Date transDate, int quantity, double price,
			double totalAmount, String remarks) {
		super();
		this.transId = transId;
		this.customerName = customerName;
		this.itemName = itemName;
		this.transDate = transDate;
		this.quantity = quantity;
		this.price = price;
		this.totalAmount = totalAmount;
		this.remarks = remarks;
	}
	public PosBean() {
		// TODO Auto-generated constructor stub
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	} 
	
}
