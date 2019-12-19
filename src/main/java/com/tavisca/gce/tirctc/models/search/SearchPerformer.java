package com.tavisca.gce.tirctc.models.search;

import com.tavisca.gce.tirctc.models.entities.Train;

import java.util.List;

public interface SearchPerformer {
    List<Train> search(String source, String destination) throws StationNotFoundException;
}

