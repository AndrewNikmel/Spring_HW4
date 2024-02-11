package spring_HW4.sem43.controllers;

import spring_HW4.sem43.models.Book;
import spring_HW4.sem43.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "book";
    }

    @GetMapping("/addbook")
    public String showAddBookForm() {
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addNewBook(@ModelAttribute Book book, Model model) {
        bookService.addBook(book);
        model.addAttribute("books", bookService.getAllBooks());
        return "redirect:/library";
    }
    @GetMapping("/editbook/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "editbook";
    }

    @PostMapping("/editbook")
    public String editBook(@ModelAttribute Book book, Model model) {
        bookService.editBook(book);
        model.addAttribute("books", bookService.getAllBooks());
        return "redirect:/library";
    }

    @PostMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        bookService.deleteBook(id);
        model.addAttribute("books", bookService.getAllBooks());
        return "redirect:/library";
    }


}
