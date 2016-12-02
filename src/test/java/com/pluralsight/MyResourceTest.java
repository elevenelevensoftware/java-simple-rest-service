package com.pluralsight;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class MyResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig().packages("com.pluralsight");
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }

    @Test
    public void givenPathToNonExistentReseourceThenShouldReturnNotFoundErrorHTTPError() {
        Response result = target("nonexistentresource").request().get();
        Assert.assertThat(result.getStatus(), is(equalTo(HttpStatus.NOT_FOUND_404.getStatusCode())));
    }
}
