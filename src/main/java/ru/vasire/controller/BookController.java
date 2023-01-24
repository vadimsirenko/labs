package ru.vasire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vasire.dao.BookDAO;
import ru.vasire.dao.PersonDAO;
import ru.vasire.model.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    public BookController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", bookDAO.getAll());
        return "books/index";
    }

    @GetMapping("/new")
    public String showNew(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {
        //personValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors())
            return "books/new";
        bookDAO.create(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id){
        model.addAttribute("book", bookDAO.show(id));
        model.addAttribute("people", personDAO.getAll());
        return "books/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookDAO.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@PathVariable("id") int id,
                       @ModelAttribute("book") @Valid Book book,
                       BindingResult bindingResult) {
        //personValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors())
            return "books/edit";
        bookDAO.update(id, book);
        return "redirect:/books";
    }

    @PatchMapping("/checkout")
    public String setPerson(@ModelAttribute("book") Book book) {
        //personValidator.validate(person, bindingResult);

        System.out.println("book = " + book);
        bookDAO.setPerson(book);
        return "redirect:/books";
    }

    @PatchMapping("/checkin")
    public String checkin(@ModelAttribute("book") Book book) {
        //personValidator.validate(person, bindingResult);

        System.out.println("book = " + book);
        bookDAO.setPerson(book);
        return "redirect:/books";
    }
}
