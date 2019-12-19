package com.tavisca.gce.tirctc.models.dao;

import com.tavisca.gce.tirctc.models.datapersistance.StationRepository;
import com.tavisca.gce.tirctc.models.entities.Station;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StationDataPersistor implements DataPersister {
    @Autowired
    StationRepository stationRepository;

    @Override
    public void save(Object object) {
        Station station = (Station)object;
        stationRepository.save(station);
    }

    @Override
    public void delete(Object object) {
        Station station = (Station)object;
        stationRepository.delete(station);
    }

    @Override
    public List<Station> findAll() {
         return stationRepository.findAll();
    }

    public Station findByName(String stationName)
    {
      return stationRepository.findByName(stationName);
    }
}
