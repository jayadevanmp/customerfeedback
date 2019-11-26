package com.ibm.feedback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Access;
import javax.persistence.AccessType;

@Entity
@Access(AccessType.PROPERTY)
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cid;
	public Long getcId() {
		return cid;
	}

	public void setcId(Long cid) {
		this.cid = cid;
	}


@NotNull
private Integer id;
@NotEmpty
private String firstName;
@NotEmpty
private String lastName;
@NotEmpty
private String phoneNumber;
@NotEmpty
private String email;
@NotEmpty
private String place;
@NotEmpty
private String date;
@NotEmpty
private String type;

/**
* No args constructor for use in serialization
*
*/
public Customer() {
}

/**
*
* @param date
* @param firstName
* @param lastName
* @param phoneNumber
* @param id
* @param place
* @param type
* @param email
*/
public Customer(Integer id, String firstName, String lastName, String phoneNumber, String email, String place, String date, String type) {
super();
this.id = id;
this.firstName = firstName;
this.lastName = lastName;
this.phoneNumber = phoneNumber;
this.email = email;
this.place = place;
this.date = date;
this.type = type;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getPhoneNumber() {
return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPlace() {
return place;
}

public void setPlace(String place) {
this.place = place;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

}
