package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    public ParkingLot(int id, String name, String address, List<Spot> spotList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.spotList = spotList;
    }

    public ParkingLot() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spots) {
        this.spotList = spots;
    }

    @OneToMany(mappedBy = "parkingLot",cascade = CascadeType.ALL)
    private List<Spot> spotList = new ArrayList<>();

}
