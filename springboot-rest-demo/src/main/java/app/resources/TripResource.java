package app.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import app.model.Trip;
import app.service.TripService;

@Path("/trip")
public class TripResource {
	final static Logger logger = Logger.getLogger(TripResource.class);
	@Autowired
	TripService ts;

	@GET
	@Path("/all")
	@Produces("application/json")
	public Response getAllTrips() {
		logger.info("get all trips");
		List<Trip> trips = ts.getAllTrip();
		return Response.ok().entity(trips).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getBytripId(@PathParam("id") Long id) {
		logger.info("get trip by id:" + id);
		Trip trip = ts.getBytripId(id);
		if (trip == null) {
			logger.info("trip_id not exist");
			throw new RuntimeException("trip_id doesn't exist");
		} else {
			return Response.ok().entity(trip).build();
		}
	}

	@POST
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addTrip(Trip trip) {
		try {
			logger.info("add new trip");
			ts.addTrip(trip);
		} catch (Exception e) {
			logger.error("show error message :" + e.getMessage());
			return Response.ok().entity(e.getMessage()).build();
		}
		return Response.ok().entity("trip added successfully.").build();

	}

	@DELETE
	@Path("/delete/{trip_id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response deleteTrip(@PathParam("trip_id") Long trip_id) {
		logger.info("delete trip by id:" + trip_id);
		ts.deleteTrip(trip_id);
		return Response.ok().build();
	}

	@PUT
	@Path("/update/{trip_id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateTrip(Trip trip, @PathParam("trip_id") Long trip_id) {
		logger.info("update trip by id:" + trip_id);
		ts.updateTrip(trip_id, trip);
		return Response.ok().build();
	}
}
