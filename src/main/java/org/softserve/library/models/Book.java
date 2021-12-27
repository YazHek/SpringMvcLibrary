package org.softserve.library.models;

import java.time.LocalDateTime;

public class Book {


    private int id;

    public void setId(int id) {
        this.id = id;
    }

    private String title;
    //private Category category_id;
    private LocalDateTime publication_date;
    private int copies_owned;

    public int getId() {
        return id;
    }

    public Book(){

    }

    public Book(int id, String title, LocalDateTime publication_date, int copies_owned) {
        this.id = id;
        this.title = title;
        this.publication_date = publication_date;
        this.copies_owned = copies_owned;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public LocalDateTime getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(LocalDateTime publication_date) {
        this.publication_date = publication_date;
    }

    public int getCopies_owned() {
        return copies_owned;
    }

    public void setCopies_owned(int copies_owned) {
        this.copies_owned = copies_owned;
    }
}
