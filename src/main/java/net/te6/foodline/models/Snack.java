package net.te6.foodline.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by hicham on 08/02/2017.
 */
@Entity
@DiscriminatorValue(value = "snack")
@org.hibernate.annotations.DiscriminatorOptions(force = true)
public class Snack extends User {
	private String name;
	private String phone;
	private long joinDate;
	@ManyToOne
	@JoinColumn(nullable=true)
	private Quartier quartier;

	private Double lat;
	private Double lng;

	public Snack() {
		super();
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(long joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return super.toString() + "Snack [name=" + name + ", phone=" + phone
				+ ", joinDate=" + joinDate + ", quartier=" + quartier
				+ ", lat=" + lat + ", lng=" + lng + "]";
	}

}
