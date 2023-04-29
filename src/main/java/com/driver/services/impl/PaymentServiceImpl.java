package com.driver.services.impl;

import com.driver.DTO.responseDto.PaymentDetailResponseDto;
import com.driver.model.Payment;
import com.driver.model.PaymentMode;
import com.driver.model.Reservation;
import com.driver.repository.PaymentRepository;
import com.driver.repository.ReservationRepository;
import com.driver.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ReservationRepository reservationRepository2;
    @Autowired
    PaymentRepository paymentRepository2;

    @Override
    public PaymentDetailResponseDto pay(Integer reservationId, int amountSent, String mode) throws Exception {
        Payment payment = null;
        Reservation reservation = reservationRepository2.findById(reservationId).get();
        int numOfHours = reservation.getNumberOfHours();
        int pricePerHour = reservation.getSpot().getPricePerHour();
        int billAmount = numOfHours * pricePerHour;
        if(amountSent < billAmount)
            throw new Exception("Insufficient Amount");
        if(!(mode.equals("cash") || mode.equals("card") || mode.equals("upi")))
            throw new Exception("Payment mode not detected");
        if(mode.equals("cash")){
            payment = new Payment(true,PaymentMode.CASH);
        }
        if(mode.equals("card")){
            payment = new Payment(true,PaymentMode.CARD);
        }
        if(mode.equals("upi")){
            payment = new Payment(true,PaymentMode.UPI);
        }
        reservation.setPayment(payment);
        reservation.getSpot().setOccupied(true);
        payment.setReservation(reservation);
        paymentRepository2.save(payment);
        return new PaymentDetailResponseDto(reservationId,true);
    }
}
