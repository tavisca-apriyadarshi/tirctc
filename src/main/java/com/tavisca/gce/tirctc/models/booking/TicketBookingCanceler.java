package com.tavisca.gce.tirctc.models.booking;

import com.tavisca.gce.tirctc.models.dto.TicketInformationHolder;
import com.tavisca.gce.tirctc.models.entities.Booking;
import com.tavisca.gce.tirctc.models.entities.Stop;
import com.tavisca.gce.tirctc.models.entities.Train;

import java.util.List;

public class TicketBookingCanceler {
    private Train train;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void cancelTicket(Booking booking) {

            List<Stop> stops = train.getStops();
            Stop source = null;
            Stop destination = null;
            for (Stop stop : stops) {
                if (stop.getStationName().equalsIgnoreCase(booking.getSource())) {
                    source = stop;
                }
            }

            for (Stop stop : stops) {
                if (stop.getStationName().equalsIgnoreCase(booking.getDestination())) {
                    destination = stop;
                }
            }

            int sourceStationIndex = stops.indexOf(source);
            int destinationStationIndex = stops.indexOf(destination);

            Stop currentStop = source;
            if (sourceStationIndex < destinationStationIndex) {
                for (int i = sourceStationIndex; i <= destinationStationIndex; i++) {
                    currentStop = stops.get(i);
                    currentStop.getTrainInformation().put(booking.getBoggyType(), currentStop.getTrainInformation().get(booking.getBoggyType()) + booking.getNo_OfTickets());
                }
            }

    }
}
