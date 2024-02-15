package com.learning.SpringRestTicketBookingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
   private String city;
   private  String name;
   private  String packageType;
   private  Double budget;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Tourist(Integer tid, String city, String name, String packageType, Double budget) {
        this.tid = tid;
        this.city = city;
        this.name = name;
        this.packageType = packageType;
        this.budget = budget;
    }

    public Tourist() {
    }
}
