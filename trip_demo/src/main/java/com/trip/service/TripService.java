package com.trip.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.model.Trip;

@Service
public class TripService {
	@Autowired
	private TripRepository tripRepository;

	// get
	public List<Trip> getAllTrip() {
		List<Trip> trips = new ArrayList<>();
		tripRepository.findAll().forEach(trips::add);
		return trips;
	}

	// get one
	public Trip getBytripId(Long id) {
		return tripRepository.findOne(id);
	}

	// save
	public void addTrip(Trip trip) {
		tripRepository.save(trip);
	}

	// delete
	public void deleteTrip(Long id) {
		tripRepository.delete(id);
	}

	// update
	public void updateTrip(Long id, Trip trip) {
		trip.setTripId(id);
		tripRepository.save(trip);

	}

}
