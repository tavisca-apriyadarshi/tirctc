package com.tavisca.gce.tirctc.models.datapersistance;

import com.tavisca.gce.tirctc.models.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StationRepository extends JpaRepository<Station,String> {
Station findByName(String name);
}
