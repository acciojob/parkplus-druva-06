package com.driver.DTO.responseDto;

public class ReservationDetailResponseDto {
    private int userId;
    private int parkingLotId;
    private int timeInHours;
    private boolean Reserved = false;

    public ReservationDetailResponseDto(int userId, int parkingLotId, int timeInHours, boolean reserved) {
        this.userId = userId;
        this.parkingLotId = parkingLotId;
        this.timeInHours = timeInHours;
        Reserved = reserved;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getTimeInHours() {
        return timeInHours;
    }

    public void setTimeInHours(int timeInHours) {
        this.timeInHours = timeInHours;
    }

    public boolean isReserved() {
        return Reserved;
    }

    public void setReserved(boolean reserved) {
        Reserved = reserved;
    }
}
