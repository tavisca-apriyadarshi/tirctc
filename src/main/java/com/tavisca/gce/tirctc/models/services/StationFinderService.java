package com.tavisca.gce.tirctc.models.services;

import com.tavisca.gce.tirctc.models.dao.StationDataPersistor;
import com.tavisca.gce.tirctc.models.entities.Station;
import com.tavisca.gce.tirctc.models.search.SearchPerformerImpl;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class StationFinderService {
    @Autowired
    private StationDataPersistor stationDataPersistor;

    public void findStation(JoinPoint joinPoint)
    {
        SearchPerformerImpl searchPerformer = (SearchPerformerImpl)joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();
        String sourceName = (String)args[0];
        String destinationName = (String)args[1];
        sourceName = sourceName.trim();
        destinationName = destinationName.trim();

        Station sourceStation = stationDataPersistor.findByName(sourceName);
        Station destinationStation = stationDataPersistor.findByName(destinationName);

        searchPerformer.setSource(sourceStation);
        searchPerformer.setDestination(destinationStation);
    }
}
