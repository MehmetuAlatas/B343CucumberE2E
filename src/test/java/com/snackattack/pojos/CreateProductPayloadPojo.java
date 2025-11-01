package com.snackattack.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProductPayloadPojo implements Serializable {
	private String name;
	private String description;
	private String contents;
	private int price;
	private int discount;
	private int orderQuantity;
	private boolean popular;

	public CreateProductPayloadPojo() {
	}

	public CreateProductPayloadPojo(String name, String description, String contents, int price, int discount, int orderQuantity, boolean popular) {
		this.name = name;
		this.description = description;
		this.contents = contents;
		this.price = price;
		this.discount = discount;
		this.orderQuantity = orderQuantity;
		this.popular = popular;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setContents(String contents){
		this.contents = contents;
	}

	public String getContents(){
		return contents;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setDiscount(int discount){
		this.discount = discount;
	}

	public int getDiscount(){
		return discount;
	}

	public void setOrderQuantity(int orderQuantity){
		this.orderQuantity = orderQuantity;
	}

	public int getOrderQuantity(){
		return orderQuantity;
	}

	public void setPopular(boolean popular){
		this.popular = popular;
	}

	public boolean isPopular(){
		return popular;
	}

	@Override
 	public String toString(){
		return 
			"{" +
			"name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",contents = '" + contents + '\'' + 
			",price = '" + price + '\'' + 
			",discount = '" + discount + '\'' + 
			",orderQuantity = '" + orderQuantity + '\'' + 
			",popular = '" + popular + '\'' + 
			"}";
		}
}