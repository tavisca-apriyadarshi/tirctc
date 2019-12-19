package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.dao.BookingDataPersistor;
import com.tavisca.gce.tirctc.models.entities.Booking;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingPersistantService {
    @Autowired
    BookingDataPersistor bookingDataPersistor;

    public void newBooking(JoinPoint joinPoint){
       Booking booking =  ((TicketBookingPerformerImpl)joinPoint.getTarget()).getBooking();
       bookingDataPersistor.save(booking);
    }

    public void cancelBooking(JoinPoint joinPoint){
       Booking booking =  ((TicketBookingPerformerImpl)joinPoint.getTarget()).getBooking();
       bookingDataPersistor.delete(booking);
    }
}
