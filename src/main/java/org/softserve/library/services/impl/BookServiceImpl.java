package org.softserve.library.services.impl;

import org.softserve.library.models.Book;
import org.softserve.library.services.BookService;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    public static final String URL = "jdbc:postgresql://localhost:5432/library";
    public static final String USR = "postgres";
    public static final String PSS = "12345";

    private static Connection connection;

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USR, PSS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book readById(int id) {
        return null;
    }

    @Override
    public Book update(int id, Book book) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM book";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));

                books.add(book);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
