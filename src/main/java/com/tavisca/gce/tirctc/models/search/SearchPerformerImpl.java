package com.tavisca.gce.tirctc.models.search;

import com.tavisca.gce.tirctc.models.entities.Station;
import com.tavisca.gce.tirctc.models.entities.Stop;
import com.tavisca.gce.tirctc.models.entities.Train;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchPerformerImpl implements SearchPerformer {
    private Station source;

    public Station getSource() {
        return source;
    }

    public void setSource(Station source) {
        this.source = source;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    private Station destination;

    public List<Train> search(String source, String destination) throws StationNotFoundException {
        if(source!=null&&destination!=null)
        {
            List<Train> trains = this.source.getTrainsContainer();
            List<Train> availableTrains = new ArrayList<>();

            Iterator<Train> iterator = trains.iterator();
            while(iterator.hasNext())
            {
                Train train = iterator.next();
                for(Stop stop : train.getStops())
                {
                    if(stop.getStationName().equalsIgnoreCase(source)&&stop.getStationName().equalsIgnoreCase(destination))
                         availableTrains.add(train);
                }
            }
          return availableTrains;
        }
        throw new StationNotFoundException();
    }
}
