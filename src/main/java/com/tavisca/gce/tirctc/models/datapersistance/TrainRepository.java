package com.tavisca.gce.tirctc.models.datapersistance;

import com.tavisca.gce.tirctc.models.entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train,Integer> {
    Train findById(int id);
}
