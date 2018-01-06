package customer.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Profile {
	@Id
	private long id;
	private String fname;
	private String lname;
	private String education;
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	@Embedded
	private Address address;
	public Profile() {}
	public Profile(String fname, String lname, long id, String education,Address address) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.id = id;
		this.education = education;
		this.address=address;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public static Address createAddress(String street, String city, String zip, String state) {
		return new Address(street, city, zip, state);
	}
@Embeddable
static class Address{

	String street;
	String city;
	String zip;
	String state;
	public Address() {}
	public Address(String street, String city, String zip, String state) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
}
