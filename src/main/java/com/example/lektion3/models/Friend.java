package com.example.lektion3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Friend {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String streetAdress;
    @ManyToOne
    private Friend bestFriend;

    public Friend() {
    }

    public Friend(Long id, String firstName, String lastName, String phone, String streetAdress, Friend bestFriend) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.streetAdress = streetAdress;
        this.bestFriend = bestFriend;
    }

    public Friend getBestFriend() {
        return bestFriend;
    }

    public void setBestFriend(Friend bestFriend) {
        this.bestFriend = bestFriend;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", streetAdress='" + streetAdress + '\'' +
                ", bestFriend='" + bestFriend + '\'' +
                '}';
    }
}
