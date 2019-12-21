package com.tavisca.gce.tirctc.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Station implements Serializable {
    @Id
    private int sid;
    private String stationName;
    @ManyToMany
    private List<Train> trainsContainer;


    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public List<Train> getTrainsContainer() {
        return trainsContainer;
    }

    public void setTrainsContainer(List<Train> trainsContainer) {
        this.trainsContainer = trainsContainer;
    }
}
