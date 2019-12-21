package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.dao.BookingDataPersistor;
import com.tavisca.gce.tirctc.models.entities.Booking;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(1)
public class BookingPersistantService {
    @Autowired
    BookingDataPersistor bookingDataPersistor;

    @After("execution(void com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl.generateTicket(..))")
    public void newBooking(JoinPoint joinPoint){
       Booking booking =  ((TicketBookingPerformerImpl)joinPoint.getTarget()).getBooking();
       bookingDataPersistor.save(booking);
    }

}
