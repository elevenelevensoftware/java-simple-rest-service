package com.pluralsight;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by ianwells on 30/11/2016.
 */

@Path("hellobobresource")
public class HelloBobResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloBobResourceMessage() {
        return "Hello Bob...";
    }
}
