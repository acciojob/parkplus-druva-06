package com.driver.services.impl;

import com.driver.DTO.responseDto.ReservationDetailResponseDto;
import com.driver.model.*;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.ReservationRepository;
import com.driver.repository.SpotRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    UserRepository userRepository3;
    @Autowired
    SpotRepository spotRepository3;
    @Autowired
    ReservationRepository reservationRepository3;
    @Autowired
    ParkingLotRepository parkingLotRepository3;
    @Override
    public Reservation reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception {
        User user;
        Reservation reservation = null;
        try{
            user = userRepository3.findById(userId).get();
            List<Spot> spotList = spotRepository3.findByParkingLotIdAndOccupied(parkingLotId,false);
            Spot minSpot = null;
            for(Spot spot:spotList){
                if(numberOfWheels > 4){
                    if(spot.getSpotType() == SpotType.OTHERS){
                        if(minSpot == null){
                            minSpot = spot;
                            continue;
                        }
                        if(minSpot.getPricePerHour() > spot.getPricePerHour()){
                            minSpot = spot;
                        }
                    }
                }
                else if(numberOfWheels > 2){
                    if(spot.getSpotType() == SpotType.OTHERS || spot.getSpotType() == SpotType.FOUR_WHEELER){
                        if(minSpot == null){
                            minSpot = spot;
                            continue;
                        }
                        if(minSpot.getPricePerHour() > spot.getPricePerHour()){
                            minSpot = spot;
                        }
                    }
                }
                else{
                    if(minSpot == null){
                        minSpot = spot;
                        continue;
                    }
                    if(minSpot.getPricePerHour() > spot.getPricePerHour()){
                        minSpot = spot;
                    }
                }
            }
            if(minSpot == null) throw new Exception("Cannot make reservation");
            reservation = new Reservation(timeInHours);
            user.getReservationList().add(reservation);
            minSpot.getReservationList().add(reservation);
            reservation.setUser(user);
            reservation.setSpot(minSpot);
            reservationRepository3.save(reservation);
        }
        catch (Exception e){
            throw new Exception("Cannot make reservation");
        }
        return reservation;
    }
}
