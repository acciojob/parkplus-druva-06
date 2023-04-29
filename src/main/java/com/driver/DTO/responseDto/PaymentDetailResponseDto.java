package com.driver.DTO.responseDto;

public class PaymentDetailResponseDto {
    private int reservationId;
    private boolean paymentCompleted = false;

    public PaymentDetailResponseDto(int reservationId, boolean paymentCompleted) {
        this.reservationId = reservationId;
        this.paymentCompleted = paymentCompleted;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isPaymentCompleted() {
        return paymentCompleted;
    }

    public void setPaymentCompleted(boolean paymentCompleted) {
        this.paymentCompleted = paymentCompleted;
    }
}
