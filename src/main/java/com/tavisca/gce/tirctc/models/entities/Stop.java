package com.tavisca.gce.tirctc.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;

public class Stop implements Serializable {
    private String stationName;
    private Timestamp arrivalTime;
    private Timestamp departureTime;
    private HashMap<Integer, java.lang.Integer> trainInformation = new HashMap<>();

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public HashMap<Integer, java.lang.Integer> getTrainInformation() {
        return trainInformation;
    }

    public void setTrainInformation(HashMap<Integer, java.lang.Integer> trainInformation) {
        this.trainInformation = trainInformation;
    }
}
