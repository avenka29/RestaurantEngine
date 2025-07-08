package com.restaurantengine.restaurantengine.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagsDTO {

    @JsonProperty("addr:city")
    private String city;

    @JsonProperty("addr:country")
    private String country;

    @JsonProperty("addr:state")
    private String state;

    @JsonProperty("contact:phone")
    private String phone;

    @JsonProperty("contact:website")
    private String website;


    @JsonProperty("diet:vegetarian")
    private String vegetarian;

    @JsonProperty("diet:halal")
    private String halal;

    public String getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getHalal() {
        return halal;
    }

    public void setHalal(String halal) {
        this.halal = halal;
    }

    public String getVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    @JsonProperty("diet:vegan")
    private String vegan;

    private String name;

    private String opening_hours;

    private String cuisine;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }


}
