package edu.sjsu.cmpe275.lab2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    String street;
    String city;
    String state;
    Integer zip;

    public Address() {

    }

    public Address(String street, String city, String state, int zip) {

        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }


    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public Integer getZip() {
        return zip;
    }


    public void setZip(Integer zip) {
        this.zip = zip;
    }


}
