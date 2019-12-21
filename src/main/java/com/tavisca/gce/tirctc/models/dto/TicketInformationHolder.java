package com.tavisca.gce.tirctc.models.dto;

import com.tavisca.gce.tirctc.models.entities.Passenger;
import com.tavisca.gce.tirctc.models.entities.TrainClass;

import java.util.Date;
import java.util.List;

public class TicketInformationHolder {
    private TrainClass boggyType;
    private int no_OfSeats;
    private String sourceName;
    private String destinationName;
    private  int trainId;
    private Date bookingDate;
    private Date journeyDate;
    private List<Passenger> passengers;

    public TrainClass getBoggyType() {
        return boggyType;
    }

    public void setBoggyType(TrainClass boggyType) {
        this.boggyType = boggyType;
    }

    public int getNo_OfSeats() {
        return no_OfSeats;
    }

    public void setNo_OfSeats(int no_OfSeats) {
        this.no_OfSeats = no_OfSeats;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}
