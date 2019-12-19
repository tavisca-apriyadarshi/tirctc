package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingCanceler;
import com.tavisca.gce.tirctc.models.dao.TrainDataPersister;
import com.tavisca.gce.tirctc.models.entities.Booking;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class CancellationService {
    @Autowired
    TrainDataPersister trainDataPersister;

    public void createBookingObject(JoinPoint joinPoint) {
        Booking booking = (Booking)joinPoint.getArgs()[0];
        ((TicketBookingCanceler)joinPoint.getTarget()).setTrain(trainDataPersister.findById(booking.getTrainId()));
    }
}
