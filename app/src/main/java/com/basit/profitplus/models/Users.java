package com.basit.profitplus.models;

public class Users {
    private String email , password , address, name , number ;

    public Users(String email, String password, String address, String name, String number) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.name = name;
        this.number = number;

    }

    public Users() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
