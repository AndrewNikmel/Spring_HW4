package Spring_HW4.sem42.services;


import Spring_HW4.sem42.models.Book;
import Spring_HW4.sem42.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> allBooks = bookRepository.findAll();
        if (allBooks.isEmpty()) {
            bookRepository.save(new Book(null, "451 градус по Фаренгейту", "Р. Брэдберри"));
            bookRepository.save(new Book(null, "Идиот", "Ф.М. Достоевский"));
            bookRepository.save(new Book(null, "Мцыри", "М.Ю. Лермонтов"));
            bookRepository.save(new Book(null, "Белая гвардия", "М.Булгаков"));
            bookRepository.save(new Book(null, "Тарас Бульба", "Н.В. Гоголь"));
            bookRepository.save(new Book(null, "1984", "Дж. Оруэлл"));
            allBooks = bookRepository.findAll();
        }
        return allBooks;
    }

    public Book getBook(long id){
        return bookRepository.findById(id);
    }
}
