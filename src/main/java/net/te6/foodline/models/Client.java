package net.te6.foodline.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by hicham on 08/02/2017.
 */

@Entity
@DiscriminatorValue(value = "client")
public class Client extends User {
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	
	private String phone;
	private Long joinDate;
	@Column(columnDefinition = "varchar(40) default 'form' ")
	private String typeAuth;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
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

	public Long getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Long joinDate) {
		this.joinDate = joinDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	public String getTypeAuth() {
		return typeAuth;
	}

	public void setTypeAuth(String typeAuth) {
		this.typeAuth = typeAuth;
	}

	@Override
	public String toString() {
		return super.toString()+ "Client [firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", joinDate=" + joinDate + ", typeAuth="
				+ typeAuth + "]";
	}



}
