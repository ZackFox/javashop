package com.phonebook.domain;


public class UserProfile {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumeber;
    private String email;

    public UserProfile() {}

    public UserProfile(String firstName, String lastName, String address, String phoneNumeber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumeber = phoneNumeber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "firstName=" + firstName +
                ", lastName=" + lastName +
                ", address=" + address +
                ", phoneNumeber=" + phoneNumeber +
                ", email=" + email ;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumeber() {
        return phoneNumeber;
    }

    public void setPhoneNumeber(String phoneNumeber) {
        this.phoneNumeber = phoneNumeber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
