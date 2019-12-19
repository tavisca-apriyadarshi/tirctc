package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.entities.Stop;
import com.tavisca.gce.tirctc.models.dto.TicketInformationHolder;
import com.tavisca.gce.tirctc.models.entities.Train;
import org.aspectj.lang.JoinPoint;
import java.util.List;

public class FindAvailabilityServicce {
    public void checkAvailability(JoinPoint joinPoint)
    {
      Object[] arguments = joinPoint.getArgs();
      TicketInformationHolder ticketInformationHolder = (TicketInformationHolder)arguments[0];
      Train train = ((TicketBookingPerformerImpl)joinPoint.getTarget()).getTrain();
      List<Stop> stops = train.getStops();

      int min = Integer.MAX_VALUE;
      for(Stop stop:stops)
      {
         int availableSeats =  stop.getTrainInformation().get(ticketInformationHolder.getBoggyType());
         if(availableSeats<min)
              min = availableSeats;
          ((TicketBookingPerformerImpl) joinPoint.getTarget()).setAvailableSeats(min);
      }
    }
}
