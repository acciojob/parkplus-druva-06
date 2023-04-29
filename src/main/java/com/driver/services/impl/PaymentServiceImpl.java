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
    public Payment pay(Integer reservationId, int amountSent, String mode) throws Exception {
        Reservation reservation = reservationRepository2.findById(reservationId).get();
        int numOfHours = reservation.getNumberOfHours();
        int pricePerHour = reservation.getSpot().getPricePerHour();
        int billAmount = numOfHours * pricePerHour;
        if(amountSent < billAmount)
            throw new Exception("Insufficient Amount");
        if(!(mode.equals("cash") || mode.equals("card") || mode.equals("upi")))
            throw new Exception("Payment mode not detected");
        Payment payment = new Payment();
        payment.setPaymentCompleted(true);
        if(mode.equals("cash")){
            payment.setPaymentMode(PaymentMode.CASH);
        }
        if(mode.equals("card")){
            payment.setPaymentMode(PaymentMode.CARD);
        }
        if(mode.equals("upi")){
            payment.setPaymentMode(PaymentMode.UPI);
        }
        reservation.setPayment(payment);
        reservation.getSpot().setOccupied(true);
        payment.setReservation(reservation);
        paymentRepository2.save(payment);
        return payment;
    }
}
