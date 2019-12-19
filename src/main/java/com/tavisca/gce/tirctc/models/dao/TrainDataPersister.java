package com.tavisca.gce.tirctc.models.dao;

import com.tavisca.gce.tirctc.models.datapersistance.TrainRepository;
import com.tavisca.gce.tirctc.models.entities.Train;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrainDataPersister implements  DataPersister {

    @Autowired
    TrainRepository trainRepository;

    @Override
    public void save(Object object) {
        Train train = (Train)object;
        trainRepository.save(train);
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public List findAll() {
        return null;
    }

    public Train findById(int id)
    {
        return  trainRepository.findById(id);
    }
}
