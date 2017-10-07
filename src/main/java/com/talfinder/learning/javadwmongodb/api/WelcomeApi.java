package com.talfinder.learning.javadwmongodb.api;

import com.talfinder.learning.javadwmongodb.resources.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Api(value = "Welcome-API", description = "Welcome-API")
public interface WelcomeApi {
    @GET
    @Path("/welcome")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "getWelcomeMessage", response = Message.class, tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = Message.class),
            @ApiResponse(code = 400, message = "Failed", response = Error.class),
            @ApiResponse(code = 500, message = "Failed", response = Error.class)})
    public Response getWelcomeMessage(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName);
}
