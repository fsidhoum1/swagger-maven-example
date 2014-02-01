package com.foo.bar.api.garage;

import com.foo.bar.model.Car;
import com.foo.bar.model.ForGeneric;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: kongchen
 * Date: 5/13/13
 */
@Path("/garage.json")
@Api(value = "/garage", description = "Operations about garages", position = 3)
@Produces( {"application/json", "application/xml"})
public class GarageResourceV1 {
    @GET
    @Path("/{garageId}")
    @ApiOperation(value = "Find garages by Id", notes = "To get garage info /* <com.foo.bar.model.G1> */",
               response = ForGeneric.class, position = 2,
    authorizations = @Authorization(value = "oauth2", scopes = {@AuthorizationScope(scope = "anything", description = "nothing")}))
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Garage not found")})
    public Response getGarageById(
            @ApiParam(value = "ID of garage that needs to be fetched", allowableValues = "range[1,100]",
                    required = true) @PathParam("garageId") String garageId)
            throws NotFoundException {
        return Response.noContent().build();
    }

    @POST
    @Path("/{garageId}")
    @ApiOperation(value = "Repair a broken car in garage", notes = "To repair car /*<com.foo.bar.model.G2,com.foo.bar.model.v2.Car>*/",
            response = ForGeneric.class, position = 1,
    authorizations = @Authorization(value = "oauth2", scopes = {@AuthorizationScope(scope = "anything", description = "nothing")}))
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Garage not found")})
    public Response getGarageById(
            @ApiParam(value = "ID of garage", allowableValues = "range[1,100]",
                    required = true) @PathParam("garageId") String garageId,
            @ApiParam(value = "broken car1", required = true) Car car)
            throws NotFoundException {
        return Response.noContent().build();
    }
}
