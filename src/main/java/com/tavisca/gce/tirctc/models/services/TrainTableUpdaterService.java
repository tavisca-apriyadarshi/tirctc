package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.dao.TrainDataPersister;
import com.tavisca.gce.tirctc.models.entities.Train;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class TrainTableUpdaterService {
    @Autowired
    TrainDataPersister trainDataPersistor;

    public void updateTrainEntity(JoinPoint joinPoint)
    {
        Train train = ((TicketBookingPerformerImpl)joinPoint.getTarget()).getTrain();
        trainDataPersistor.save(train);
    }
}
