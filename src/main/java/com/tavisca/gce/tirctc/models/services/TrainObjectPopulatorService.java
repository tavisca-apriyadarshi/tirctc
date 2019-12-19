package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.dao.TrainDataPersister;
import com.tavisca.gce.tirctc.models.dto.TicketInformationHolder;
import com.tavisca.gce.tirctc.models.entities.Train;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class TrainObjectPopulatorService {
    @Autowired
    TrainDataPersister trainDataPersistor;
    
    public void populateTrainObject(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();
        TicketInformationHolder ticketInformationHolder = (TicketInformationHolder)args[0];
        Train train = trainDataPersistor.findById(ticketInformationHolder.getTrainId());
        ((TicketBookingPerformerImpl)joinPoint.getTarget()).setTrain(train);
    }
}
