package net.te6.foodline.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
@Entity
@DiscriminatorColumn(name="admin")
public class Admin  extends User {
	private String firstName;
	private String lastName;
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

	
	
	
	

	

}
