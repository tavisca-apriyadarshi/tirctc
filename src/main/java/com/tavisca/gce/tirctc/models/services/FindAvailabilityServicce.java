package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.entities.Stop;
import com.tavisca.gce.tirctc.models.dto.TicketInformationHolder;
import com.tavisca.gce.tirctc.models.entities.Train;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Aspect
@Configuration
@Order(1)
public class FindAvailabilityServicce {

    @Before("execution(void com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl.generateTicket(..))")
    public void checkAvailability(JoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        TicketInformationHolder ticketInformationHolder = (TicketInformationHolder) arguments[0];
        Train train = ((TicketBookingPerformerImpl) joinPoint.getTarget()).getTrain();
        List<Stop> stops = train.getStops();

        int min = Integer.MAX_VALUE;
        for (Stop stop : stops) {
            int availableSeats = stop.getTrainInformation().get(ticketInformationHolder.getBoggyType());
            if (availableSeats < min)
                min = availableSeats;
            ((TicketBookingPerformerImpl) joinPoint.getTarget()).setAvailableSeats(min);
        }
    }
}
