package org.lambadaframework.example.controllers;

import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ExampleController {


    static final Logger logger = Logger.getLogger(ExampleController.class);

    static class Entity {
        public int id = 1;
        public String name;

        public Entity(String name) {
            this.name = name;
        }
    }

    @GET
    public Response indexEndpoint(
    ) {
        logger.debug("Request got");
        return Response.status(200)
                .entity(new Entity("John doe"))
                .build();
    }

    @GET
    @Path("/{name}")
    public Response exampleEndpoint(
            @PathParam("name") String name
    ) {

        logger.debug("Request got");
        return Response.status(201)
                .entity(new Entity(name))
                .build();
    }

    @GET
    @Path("/resource/{name}")
    public Response exampleSecondEndpoint(
            @PathParam("name") String name
    ) {

        logger.debug("Request got");
        return Response.status(201)
                .entity(new Entity(name))
                .build();
    }

    public static class NewEntityRequest {
        public String name;
    }

    /**
     * This controller uses automatically serialization of Request body to any POJO
     * @param requestEntity Request Entity
     * @return Response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/resource")
    public Response exampleSecondEndpointPost(
            NewEntityRequest requestEntity
    ) {

        logger.debug("Request got");
        return Response.status(201)
                .entity(new Entity(requestEntity.name))
                .build();
    }
	/**
	* This will be the request used to upload binary photos
	*/
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/v1/lambda")
	public Response upload_dat_lambda(
		NewEntityRequest rdatq
	){
		logger.debug("upload image");
		String alak = Response.readEntity(String.class);
		String abr = Response.MediaType(APPLICATION_JSON).entity().build();
		return Response.status(200)
				.entity(alak)
				.entity(abr)
				.build();
	}

	@GET
@Path("{id}")
@Consumes( MediaType.APPLICATION_JSON )
public Response getCorsByItsId(
@PathParam("id") Long id,
@QueryParam("detailed") boolean detailed_id

) {
	
	return Response.status(200)
			.entity(id)
			.entity(detailed_id)
			.header("Access-Control-Allow-Origin", "*") //allow cors access everywhere
			.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT") //allows all the methods I could think of
			.allow("OPTIONS")
			.build();
}

}
