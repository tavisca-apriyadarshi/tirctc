package com.tavisca.gce.tirctc.models.datapersistance;

import com.tavisca.gce.tirctc.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


// primary key is PNR number in Bookinng entity
public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
