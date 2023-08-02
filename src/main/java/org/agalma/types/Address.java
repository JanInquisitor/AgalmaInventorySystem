package org.agalma.types;

public class Address {
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String country;


    public Address(String streetAddress, String city, String state, String zipCode, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }
}
