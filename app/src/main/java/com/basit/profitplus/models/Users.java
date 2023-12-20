package com.basit.profitplus.models;

public class Users {
    private String email , password , cnic, name , city , number ;

    public Users(String email, String password, String cnic, String name, String city, String number) {
        this.email = email;
        this.password = password;
        this.cnic = cnic;
        this.name = name;
        this.city = city;
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

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
