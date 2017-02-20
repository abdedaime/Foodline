package net.te6.foodline.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Created by hicham on 08/02/2017.
 */
@Entity
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String ville;
	
	public Ville() {
		super();
	}

	public Ville(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}



	@Override
	public String toString() {
		return "Ville{" + "id=" + id + ", ville='" + ville + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Ville ville1 = (Ville) o;

		if (id != ville1.id)
			return false;
		return ville != null ? ville.equals(ville1.ville)
				: ville1.ville == null;

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (ville != null ? ville.hashCode() : 0);
		return result;
	}
}
