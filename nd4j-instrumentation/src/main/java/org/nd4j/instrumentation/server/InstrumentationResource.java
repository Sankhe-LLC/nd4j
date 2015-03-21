package org.nd4j.instrumentation.server;

import org.nd4j.linalg.api.instrumentation.LogEntry;
import org.nd4j.linalg.factory.Nd4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Instrumentation resource
 *
 * @author Adam Gibson
 */
@Path("/instrumentation")
@Produces(MediaType.APPLICATION_JSON)
public class InstrumentationResource {

    @GET
    @Path("/alive")
    public Response getAlive() {
        Collection<LogEntry> alive = Nd4j.getInstrumentation().getStillAlive();
        return Response.ok(alive).build();
    }

    @GET
    @Path("/statusof")
    public Response isAlive(@QueryParam("id") String id) {
        Boolean alive = Nd4j.getInstrumentation().isDestroyed(id);
        return Response.ok(alive).build();
    }


    @GET
    @Path("/dead")
    public Response getDead() {
        Collection<LogEntry> dead = Nd4j.getInstrumentation().getDestroyed();
        return Response.ok(dead).build();
    }
}
