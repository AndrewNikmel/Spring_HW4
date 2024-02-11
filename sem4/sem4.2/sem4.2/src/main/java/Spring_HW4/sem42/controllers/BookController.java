package Spring_HW4.sem42.controllers;

import Spring_HW4.sem42.services.BookService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping()
    public String bookslist(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "library";
    }

}