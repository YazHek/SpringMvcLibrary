package org.softserve.library.controllers;

import org.softserve.library.models.Book;
import org.softserve.library.services.BookService;
import org.softserve.library.services.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookServiceImpl bookService;

    @Autowired
    public BooksController(BookServiceImpl bookService){
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public String readById(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookService.readById(id));
        return "create-book";
    }

    @GetMapping("/new")
    public String createBook(Model model){
        model.addAttribute("book", new Book());
        return "create-book";
    }

    @PostMapping()
    public String createBook(@ModelAttribute("book") Book book){
        bookService.create(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editBook(Model model, @PathVariable("id") int id){
        model.addAttribute("book", bookService.readById(id));
        return "book-edit";
    }

    @PostMapping("/{id}")
    public String updateBook(@ModelAttribute("book") Book book, @PathVariable("id") int id){
        bookService.update(id, book);

        return "redirect:/books";
    }

    @GetMapping()
    public String getAllBooks(Model model){
        model.addAttribute("book", bookService.getAll());
        return "book-list";
    }
}
