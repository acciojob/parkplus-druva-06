package com.driver.DTO.responseDto;

import com.driver.model.Reservation;
import com.driver.model.SpotType;

import java.util.List;


public class SpotDetailResponseDto {
    private SpotType spotType;
    private int pricePerHour;
    private boolean occupied;
    public SpotDetailResponseDto(){}
    public SpotDetailResponseDto(SpotType spotType, int pricePerHour, boolean occupied) {
        this.spotType = spotType;
        this.pricePerHour = pricePerHour;
        this.occupied = occupied;
    }
    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

}
