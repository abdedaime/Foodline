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
public class Quartier  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    private Ville ville;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Quartier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ville=" + ville+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quartier quartier = (Quartier) o;

        if (id != quartier.id) return false;
        if (name != null ? !name.equals(quartier.name) : quartier.name != null) return false;
        return ville != null ? ville.equals(quartier.ville) : quartier.ville == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        return result;
    }
    
    
    
}