package com.restaurantengine.restaurantengine.Model;

import jakarta.persistence.*;

@Entity
@Table(name="restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String osm_id;
    private double lat;
    private double lon;
    private String city;
    private String country;
    private String state;
    private String website;
    @Enumerated(EnumType.STRING)
    private DietLevel vegetarian;

    @Enumerated(EnumType.STRING)
    private DietLevel halal;

    @Enumerated(EnumType.STRING)
    private DietLevel vegan;
    private String name;

    public Restaurant(String osm_id, double lat, double lon, String city, String country,
                      String state, String website, String vegetarian, String halal,
                      String vegan, String name) {
        setOsm_id(osm_id);
        setLat(lat);
        setLon(lon);
        setCity(city);
        setCountry(country);
        setState(state);
        setWebsite(website);
        setVegetarian(vegetarian);
        setHalal(halal);
        setVegan(vegan);
        setName(name);
    }

    protected Restaurant() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DietLevel getVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {

        if (vegan == null) {
            this.vegan = DietLevel.NO;
        }
        else{
            this.vegan = DietLevel.fromString(vegan);
        }
    }

    public DietLevel getHalal() {
        return halal;
    }

    public void setHalal(String halal) {
        if (halal == null) {
            this.halal = DietLevel.NO;
        }
        else{
            this.halal = DietLevel.fromString(halal);
        }

    }

    public DietLevel getVegetarian() {

        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        if (vegetarian == null) {
            this.vegetarian = DietLevel.NO;
        }
        else{
            this.vegetarian = DietLevel.fromString(vegetarian);
        }
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getOsm_id() {
        return osm_id;
    }

    public void setOsm_id(String osm_id) {
        this.osm_id = osm_id;
    }
}
