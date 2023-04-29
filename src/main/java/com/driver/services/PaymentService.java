package com.driver.services;

import com.driver.DTO.responseDto.PaymentDetailResponseDto;

public interface PaymentService {
    PaymentDetailResponseDto pay(Integer reservationId, int amountSent, String mode) throws Exception;
}
