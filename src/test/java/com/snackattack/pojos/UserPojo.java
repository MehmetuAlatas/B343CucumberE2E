package com.snackattack.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo implements Serializable {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private String zipCode;

	public UserPojo() {
	}

	public UserPojo(String firstName, String lastName, String email, String phoneNumber, String address, String zipCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.zipCode = zipCode;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}

	public String getZipCode(){
		return zipCode;
	}

	@Override
 	public String toString(){
		return 
			"UserPojo{" + 
			"firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",email = '" + email + '\'' + 
			",phoneNumber = '" + phoneNumber + '\'' + 
			",address = '" + address + '\'' + 
			",zipCode = '" + zipCode + '\'' + 
			"}";
		}
}