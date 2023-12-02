package com.example.addressboock.models;

public class Users {
    private String Name;
    private String Lastname;
    private String Telephone;
    private String Mail;
    private String Address;


    public Users(String Name, String Lastname, String telephone, String Mail, String Address) {
        this.Name = Name;
        this.Lastname= Lastname;
        this.Telephone = telephone;
        this.Mail = Mail;
        this.Address = Address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "Name='" + Name + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", Mail='" + Mail + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}



