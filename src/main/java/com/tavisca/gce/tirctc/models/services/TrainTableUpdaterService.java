package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.dao.TrainDataPersister;
import com.tavisca.gce.tirctc.models.entities.Train;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(2)
public class TrainTableUpdaterService {
    @Autowired
    TrainDataPersister trainDataPersistor;

    @After("execution(void com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl.generateTicket(..))")
    public void updateTrainEntity(JoinPoint joinPoint)
    {
        Train train = ((TicketBookingPerformerImpl)joinPoint.getTarget()).getTrain();
        trainDataPersistor.save(train);
    }
}
