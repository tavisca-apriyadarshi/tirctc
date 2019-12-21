package com.tavisca.gce.tirctc.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;

@Embeddable
public class Stop implements Serializable {
    private String stationName;
    private Timestamp arrivalTime;
    private Timestamp departureTime;

    @ElementCollection
    @CollectionTable(name = "trainClass_availableSeats_mapping",
            joinColumns = {@JoinColumn(name = "station_name",referencedColumnName = "stationName")})
    @MapKeyEnumerated (EnumType.STRING)
    @Column(name = "class")
    private HashMap<TrainClass, Integer> trainInformation = new HashMap<>();

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

    public HashMap<TrainClass, Integer> getTrainInformation() {
        return trainInformation;
    }

    public void setTrainInformation(HashMap<TrainClass, Integer> trainInformation) {
        this.trainInformation = trainInformation;
    }
}
