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
public class Recherche   {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private int rayon;
    private double lng;
    private double lat;
    @ManyToOne
    private Quartier quartier;
    @ManyToOne
    private Recherche recherche;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }

    public Recherche getRecherche() {
        return recherche;
    }

    public void setRecherche(Recherche recherche) {
        this.recherche = recherche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recherche recherche1 = (Recherche) o;

        if (id != recherche1.id) return false;
        if (rayon != recherche1.rayon) return false;
        if (Double.compare(recherche1.lng, lng) != 0) return false;
        if (Double.compare(recherche1.lat, lat) != 0) return false;
        if (quartier != null ? !quartier.equals(recherche1.quartier) : recherche1.quartier != null)
            return false;
        return recherche != null ? recherche.equals(recherche1.recherche) : recherche1.recherche == null;

    }

    @Override
    public String toString() {
        return "Recherche{" +
                "id=" + id +
                ", rayon=" + rayon +
                ", lng=" + lng +
                ", lat=" + lat +
                ", quartier=" + quartier +
                ", recherche=" + recherche +
                '}';
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + rayon;
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (quartier != null ? quartier.hashCode() : 0);
        result = 31 * result + (recherche != null ? recherche.hashCode() : 0);
        return result;
    }
}
