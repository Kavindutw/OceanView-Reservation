package com.example.oceanviewreservation.model;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private String reservationNo;
    private String guestName;
    private String address;
    private String contactNumber;
    private String roomTypeCode;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation() {}

    public Reservation(int id, String reservationNo, String guestName, String address,
                       String contactNumber, String roomTypeCode, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.reservationNo = reservationNo;
        this.guestName = guestName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.roomTypeCode = roomTypeCode;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() { return id; }
    public String getReservationNo() { return reservationNo; }
    public String getGuestName() { return guestName; }
    public String getAddress() { return address; }
    public String getContactNumber() { return contactNumber; }
    public String getRoomTypeCode() { return roomTypeCode; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }

    public void setId(int id) { this.id = id; }
    public void setReservationNo(String reservationNo) { this.reservationNo = reservationNo; }
    public void setGuestName(String guestName) { this.guestName = guestName; }
    public void setAddress(String address) { this.address = address; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setRoomTypeCode(String roomTypeCode) { this.roomTypeCode = roomTypeCode; }
    public void setCheckIn(LocalDate checkIn) { this.checkIn = checkIn; }
    public void setCheckOut(LocalDate checkOut) { this.checkOut = checkOut; }
}
