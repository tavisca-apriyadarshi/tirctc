package com.tavisca.gce.tirctc.models.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Entity
public class Train implements Serializable {

    @Id
    private int trainId;
    private String trainName;

    ///////////////////////////////////////////////////?????????????????????????????????????????????????
    private HashMap<Integer, Integer> trainSeatsInformationContainer = new HashMap<Integer, Integer>();
    private String source;
    private String destination;

    @ElementCollection
    private List<Stop> stops;

    @ManyToMany(mappedBy = "trainsContainer")
    private List<Station> stations;

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public HashMap<Integer, Integer> getTrainSeatsInformationContainer() {
        return trainSeatsInformationContainer;
    }

    public void setTrainSeatsInformationContainer(HashMap<Integer, Integer> trainSeatsInformationContainer) {
        this.trainSeatsInformationContainer = trainSeatsInformationContainer;
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

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
}
