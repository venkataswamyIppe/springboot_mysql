package com.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trip.model.Trip;
import com.trip.service.TripService;

@RestController
@RequestMapping(path = "/trip")
public class TripController {

	@Autowired
	TripService ts;

	@RequestMapping("/all")
	public List<Trip> getAllTrips() {
		return ts.getAllTrip();
	}

	@RequestMapping("/{id}")
	public Trip getBytripId(@PathVariable("id") Long id) {
		return ts.getBytripId(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public void addTrip(@RequestBody Trip trip) {
		ts.addTrip(trip);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deleteTrip(@PathVariable("id") Long id) {
		ts.deleteTrip(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void updateTrip(@RequestBody Trip trip, @PathVariable Long id) {
		ts.updateTrip(id, trip);
	}

}
