package org.softserve.library.services;


import org.softserve.library.models.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);
    Book readById(int id);
    Book update(int id, Book book);
    void delete(long id);
    List<Book> getAll();
}
