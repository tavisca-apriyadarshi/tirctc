package com.tavisca.gce.tirctc.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking implements Serializable {
    private int id;
    private int trainId;
    private String trainName;
    private int no_OfTickets;
    private Date bookingDate;
    private Date journeyDate;
    private String source;
    private String destination;
    private int boggyType;
    List<Passenger> passengers = new ArrayList<>();


    public int getBoggyType() {
        return boggyType;
    }

    public void setBoggyType(int boggyType) {
        this.boggyType = boggyType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getNo_OfTickets() {
        return no_OfTickets;
    }

    public void setNo_OfTickets(int no_OfTickets) {
        this.no_OfTickets = no_OfTickets;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}
