package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.dao.TrainDataPersister;
import com.tavisca.gce.tirctc.models.dto.TicketInformationHolder;
import com.tavisca.gce.tirctc.models.entities.Train;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(0)
public class TrainObjectPopulatorService {
    @Autowired
    TrainDataPersister trainDataPersistor;

    @Before("execution(void com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl.generateTicket(..))")
    public void populateTrainObject(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();
        TicketInformationHolder ticketInformationHolder = (TicketInformationHolder)args[0];
        Train train = trainDataPersistor.findById(ticketInformationHolder.getTrainId());
        ((TicketBookingPerformerImpl)joinPoint.getTarget()).setTrain(train);
    }
}
