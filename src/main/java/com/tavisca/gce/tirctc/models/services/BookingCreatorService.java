package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.entities.Booking;
import com.tavisca.gce.tirctc.models.dto.TicketInformationHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(0)
public class BookingCreatorService {

    @After("execution(void com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl.generateTicket(..))")
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
        booking.setBoggyType(ticketInformationHolder.getBoggyType());
        booking.setTrainName(((TicketBookingPerformerImpl)joinPoint).getTrain().getTrainName());

        ((TicketBookingPerformerImpl)joinPoint.getTarget()).setBooking(booking);
    }

}
