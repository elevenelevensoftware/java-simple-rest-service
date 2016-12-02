package com.pluralsight;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by ianwells on 30/11/2016.
 */
public class BooksResourceTest extends JerseyTest {

    private static final String BOOKS_ENDPOINT = "books";

    @Override
    protected Application configure() {
        return new ResourceConfig().packages("com.pluralsight");
    }

    @Test
    public void givenBooksResourceNeededThenShouldBeFound() {
        Response response = target(BOOKS_ENDPOINT).request().get();
        Assert.assertThat(response.getStatus(), is(equalTo(HttpStatus.OK_200.getStatusCode())));
    }

    @Test
    public void givenBookByIdNeededThenShouldReturnBookWithThatId() {
        Book result = target(BOOKS_ENDPOINT + "/1").request().get(Book.class);
        Assert.assertThat(result.getId(), is(equalTo("1")));
    }

    @Test
    public void givenCollectionsOfBooksNeededThenShouldReturnCollection() {
        Collection<Book> response = target(BOOKS_ENDPOINT).request().get(new GenericType<Collection<Book>>() {});
        assertEquals(2, response.size());
    }

}