package com.pluralsight;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ianwells on 30/11/2016.
 */
public class BookDao {

    private Map<String, Book> books;

    public BookDao() {

        books = new HashMap<>();

        Book firstBook = new Book();
        firstBook.setId("1");
        firstBook.setTitle("weaveworld");
        firstBook.setAuthor("Clive Barker");
        firstBook.setIsbn("1111");
        firstBook.setPublished(new Date());

        Book secondBook = new Book();
        secondBook.setId("2");
        secondBook.setTitle("hellraiser");
        secondBook.setAuthor("Clive Barker");
        secondBook.setIsbn("1122");
        secondBook.setPublished(new Date());

        books.put(firstBook.getId(), firstBook);
        books.put(secondBook.getId(), secondBook);
    }

    public Collection<Book> getBooks() {
        return (books.values());
    }

    public Book getBook(String id) {
        return (books.get(id));
    }
}
