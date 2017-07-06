package app.service;

import org.springframework.data.repository.CrudRepository;

import app.model.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {

}
