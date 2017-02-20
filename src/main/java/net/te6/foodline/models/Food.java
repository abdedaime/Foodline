package net.te6.foodline.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by hicham on 08/02/2017.
 */
@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private Double price;
	@ManyToOne
	private Categorie categorie;
	@ManyToOne
	private Snack snack;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Snack getSnack() {
		return snack;
	}

	public void setSnack(Snack snack) {
		this.snack = snack;
	}

	@Override
	public String toString() {
		return "Food{" + "id=" + id + ", name='" + name + '\'' + ", price='"
				+ price + '\'' + ", categorie=" + categorie + ", snack="
				+ snack + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Food food = (Food) o;

		if (id != food.id)
			return false;
		if (name != null ? !name.equals(food.name) : food.name != null)
			return false;
		if (price != null ? !price.equals(food.price) : food.price != null)
			return false;
		if (categorie != null ? !categorie.equals(food.categorie)
				: food.categorie != null)
			return false;
		return snack != null ? snack.equals(food.snack) : food.snack == null;

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (categorie != null ? categorie.hashCode() : 0);
		result = 31 * result + (snack != null ? snack.hashCode() : 0);
		return result;
	}
}
