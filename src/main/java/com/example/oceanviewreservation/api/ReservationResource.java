package com.example.oceanviewreservation.api;

import com.example.oceanviewreservation.api.dto.ReservationRequest;
import com.example.oceanviewreservation.api.dto.ReservationResponse;
import com.example.oceanviewreservation.model.Reservation;
import com.example.oceanviewreservation.service.ReservationService;
import com.example.oceanviewreservation.service.impl.ReservationServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/reservations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationResource {

    private final ReservationService reservationService = new ReservationServiceImpl();

    @GET
    @Path("/{reservationNo}")
    public ReservationResponse get(@PathParam("reservationNo") String reservationNo) {
        Reservation r = reservationService.getByReservationNo(reservationNo);
        ReservationResponse res = new ReservationResponse();

        if (r == null) {
            res.message = "Reservation not found.";
            return res;
        }

        res.reservationNo = r.getReservationNo();
        res.guestName = r.getGuestName();
        res.address = r.getAddress();
        res.contactNumber = r.getContactNumber();
        res.roomTypeCode = r.getRoomTypeCode();
        res.checkIn = r.getCheckIn().toString();
        res.checkOut = r.getCheckOut().toString();
        res.message = "OK";
        return res;
    }

    @POST
    public ReservationResponse create(ReservationRequest req) {
        ReservationResponse res = new ReservationResponse();

        try {
            Reservation r = new Reservation();
            r.setReservationNo(req.reservationNo);
            r.setGuestName(req.guestName);
            r.setAddress(req.address);
            r.setContactNumber(req.contactNumber);
            r.setRoomTypeCode(req.roomTypeCode);
            r.setCheckIn(LocalDate.parse(req.checkIn));
            r.setCheckOut(LocalDate.parse(req.checkOut));

            reservationService.addReservation(r);

            res.reservationNo = r.getReservationNo();
            res.message = "Created";
            return res;

        } catch (Exception e) {
            res.message = "Error: " + e.getMessage();
            return res;
        }
    }
}
