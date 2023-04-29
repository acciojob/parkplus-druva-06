package com.driver.services.impl;

import com.driver.DTO.responseDto.ParkingLotDetailResponseDto;
import com.driver.DTO.responseDto.SpotDetailResponseDto;
import com.driver.model.ParkingLot;
import com.driver.model.Spot;
import com.driver.model.SpotType;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(name);
        parkingLot.setAddress(address);
        parkingLotRepository1.save(parkingLot);
        return parkingLot;
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
        SpotType spotType = SpotType.OTHERS;
        if(numberOfWheels == 2)
            spotType = SpotType.TWO_WHEELER;
        if(numberOfWheels == 4)
            spotType = SpotType.FOUR_WHEELER;
        Spot spot = new Spot();
        spot.setSpotType(spotType);
        spot.setPricePerHour(pricePerHour);
        ParkingLot parkingLot = parkingLotRepository1.findById(parkingLotId).get();
        spot.setParkingLot(parkingLot);
        parkingLot.getSpotList().add(spot);
        parkingLotRepository1.save(parkingLot);
        return spot;
    }

    @Override
    public void deleteSpot(int spotId) {
        spotRepository1.deleteById(spotId);
    }


    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {
        Spot spot = spotRepository1.findByIdAndParkingLotId(spotId,parkingLotId);
        spot.setPricePerHour(pricePerHour);
        spotRepository1.save(spot);
        return spot;
    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
        parkingLotRepository1.deleteById(parkingLotId);
    }
}
