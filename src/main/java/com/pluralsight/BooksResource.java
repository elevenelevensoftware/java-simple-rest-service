package com.pluralsight;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by ianwells on 30/11/2016.
 */


@Path("/books")
public class BooksResource {

    @GET
    public String getResourceFoundMessage() {
        return "You are at the books resource";
    }
}
