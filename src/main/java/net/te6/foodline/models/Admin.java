package net.te6.foodline.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
@Entity
@DiscriminatorColumn(name="admin")
public class Admin  extends User {
	private String FirstName;
	private String LastName;
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	

	

}
