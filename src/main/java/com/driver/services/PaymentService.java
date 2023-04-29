package com.driver.services;

import com.driver.DTO.responseDto.PaymentDetailResponseDto;
import com.driver.model.Payment;

public interface PaymentService {
    Payment pay(Integer reservationId, int amountSent, String mode) throws Exception;
}
