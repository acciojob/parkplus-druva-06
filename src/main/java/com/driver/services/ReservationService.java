package com.driver.services;

import com.driver.DTO.responseDto.ReservationDetailResponseDto;

public interface ReservationService {
    ReservationDetailResponseDto reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception;
}
