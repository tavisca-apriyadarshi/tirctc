package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.entities.Booking;
import com.tavisca.gce.tirctc.models.dto.TicketInformationHolder;
import org.aspectj.lang.JoinPoint;

public class BookingCreatorService {

    public void createBookingObject(JoinPoint joinPoint) {
        TicketInformationHolder ticketInformationHolder = (TicketInformationHolder)joinPoint.getArgs()[0];
        // have to create factory of booking
        Booking booking = new Booking();

        booking.setBookingDate(ticketInformationHolder.getBookingDate());
        booking.setDestination(ticketInformationHolder.getDestinationName());
        booking.setJourneyDate(ticketInformationHolder.getJourneyDate());
        booking.setNo_OfTickets(ticketInformationHolder.getNo_OfSeats());
        booking.setPassengers(ticketInformationHolder.getPassengers());
        booking.setSource(ticketInformationHolder.getSourceName());
        booking.setTrainId(ticketInformationHolder.getTrainId());
        booking.setTrainName(((TicketBookingPerformerImpl)joinPoint).getTrain().getTrainName());

        ((TicketBookingPerformerImpl)joinPoint.getTarget()).setBooking(booking);
    }

}
