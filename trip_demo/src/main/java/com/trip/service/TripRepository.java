package com.trip.service;
import org.springframework.data.repository.CrudRepository;
import com.trip.model.Trip;
public interface TripRepository extends CrudRepository<Trip,Long> {
	

}
