package com.tavisca.gce.tirctc.models.dao;

import com.tavisca.gce.tirctc.models.datapersistance.BookingRepository;
import com.tavisca.gce.tirctc.models.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingDataPersistor implements DataPersister{
 @Autowired
    BookingRepository bookingRepository;

    @Override
    public void save(Object object) {
        Booking booking = (Booking)object;
        bookingRepository.save(booking);
    }

    @Override
    public void delete(Object object) {
        Booking booking = (Booking)object;
        bookingRepository.delete(booking);
    }

    @Override
    public List findAll() {
        return bookingRepository.findAll();
    }
}
