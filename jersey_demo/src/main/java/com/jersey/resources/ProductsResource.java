package com.jersey.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.jersey.model.Product;

@Path("/products")
@Consumes("application/json")
@Produces("application/json")
public class ProductsResource {

	@GET
	public List getAll() {
		List products = new ArrayList();
		products.add(new Product(1L, "iPhone 6", "USD", 850D, 750D));
		return products;
	}

	@GET
	@Path("{id}")
	public Product getOne(@PathParam("id") Long id) {
		if (id == 888) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			return new Product(id, "iPhone 6", "USD", 850D, 750D);
		}
	}
}
