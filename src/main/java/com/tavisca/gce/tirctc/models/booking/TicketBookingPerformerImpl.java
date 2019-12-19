package com.tavisca.gce.tirctc.models.booking;

import com.tavisca.gce.tirctc.models.entities.Booking;
import com.tavisca.gce.tirctc.models.entities.Stop;
import com.tavisca.gce.tirctc.models.dto.TicketInformationHolder;
import com.tavisca.gce.tirctc.models.entities.Train;
import java.util.List;

public class TicketBookingPerformerImpl implements TicketBookingPerformer
{
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    private Booking booking;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    private Train train;

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    private int availableSeats;


    public void generateTicket(TicketInformationHolder ticketINformationHolder)
    {
      if(availableSeats>=ticketINformationHolder.getNo_OfSeats())
      {

          List<Stop> stops = train.getStops();
          Stop source = null;
          Stop destination = null;
          for(Stop stop:stops)
          {
              if(stop.getStationName().equalsIgnoreCase(ticketINformationHolder.getSourceName()))
              {
                  source = stop;
              }
          }

          for(Stop stop:stops)
          {
              if(stop.getStationName().equalsIgnoreCase(ticketINformationHolder.getDestinationName()))
              {
                  destination= stop;
              }
          }

       int sourceStationIndex = stops.indexOf(source);
       int destinationStationIndex = stops.indexOf(destination);

       Stop currentStop = source;
       if(sourceStationIndex<destinationStationIndex)
       {
            for(int i=sourceStationIndex;i<=destinationStationIndex;i++)
            {
                currentStop = stops.get(i);
                currentStop.getTrainInformation().put(ticketINformationHolder.getBoggyType(),currentStop.getTrainInformation().get(ticketINformationHolder.getBoggyType())-ticketINformationHolder.getNo_OfSeats());
            }
       }
      }
    }
}
