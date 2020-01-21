package com.lti.model;

import javax.persistence.*;

@Entity
@Table(name="address")
@SequenceGenerator(name="seq", sequenceName="address_seq",allocationSize=1,initialValue=1) // may get an undesired value
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")	// link sequence with class attribute
	private int addressId;
	private String city;
	private String pin;
	
	@OneToOne(mappedBy="address")	
	private Student student;
	

	public Address() {
		super();
	}

	public Address(String city, String pin) {
		super();
		this.city = city;
		this.pin = pin;
	}

	public Address(int addressId, String city, String pin) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.pin = pin;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", pin=" + pin + "]";
	}
}
