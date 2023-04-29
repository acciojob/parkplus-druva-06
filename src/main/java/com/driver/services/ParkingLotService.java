package com.driver.services;

import com.driver.DTO.responseDto.SpotDetailResponseDto;
import com.driver.model.ParkingLot;
import com.driver.model.Spot;

public interface ParkingLotService {
    
    void deleteSpot(int spotId);

//    Spot updateSpot(int parkingLotId, int spotId, int pricePerHour);
//
//    void deleteParkingLot(int parkingLotId);

    ParkingLot addParkingLot(String name, String address);

    SpotDetailResponseDto addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour);
}