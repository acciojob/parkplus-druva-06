package com.driver.services;

import com.driver.DTO.responseDto.ReservationDetailResponseDto;
import com.driver.model.Reservation;

public interface ReservationService {
    Reservation reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception;
}
