package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingCanceler;
import com.tavisca.gce.tirctc.models.dao.TrainDataPersister;
import com.tavisca.gce.tirctc.models.entities.Booking;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(0)
public class TrainDataForCancellationService {
    @Autowired
    TrainDataPersister trainDataPersister;

    @Before("execution(void com.tavisca.gce.tirctc.models.booking.TicketBookingCanceler.cancelTicket(..))")
    public void createBookingObject(JoinPoint joinPoint) {
        Booking booking = (Booking)joinPoint.getArgs()[0];
        ((TicketBookingCanceler)joinPoint.getTarget()).setTrain(trainDataPersister.findById(booking.getTrainId()));
    }
}
