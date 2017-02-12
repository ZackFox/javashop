package com.javashop.model;


public class CustomerProfile {
    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;

    public CustomerProfile() {
        id = 0;
        firstName = "Гость";
        login = "гость";
        password = "гость";
    }

    @Override
    public String toString() {
        return  "Id: " + id + "/ "+
                " firstName: " + firstName + " / "+
                " lastName: " + lastName + " / "+
                " address: " + address + " / " +
                " phoneNumber: " + phoneNumber + " / "+
                " login: " + login +" / "+
                " password: " + password + " / "+
                " email: " + email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
