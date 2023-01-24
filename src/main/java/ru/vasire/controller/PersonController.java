package ru.vasire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vasire.dao.BookDAO;
import ru.vasire.dao.PersonDAO;
import ru.vasire.model.Book;
import ru.vasire.model.Person;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonDAO personDAO;
    private final BookDAO bookDAO;

    public PersonController(PersonDAO personDAO, BookDAO bookDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.getAll());
        return "people/index";
    }

    @GetMapping("/new")
    public String showNew(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        //personValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors())
            return "people/new";
        personDAO.create(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.show(id));
        model.addAttribute("books", bookDAO.getBooksByPerson(id));
        return "people/show";
    }

    @DeleteMapping("/{id}")
    public String delete(Model model, @PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@PathVariable("id") int id,
                       @ModelAttribute("person") @Valid Person person,
                       BindingResult bindingResult) {
        //personValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors())
            return "people/edit";
        personDAO.update(id, person);
        return "redirect:/people";
    }
}
