package spring_HW4.sem43.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_HW4.sem43.models.Book;
import spring_HW4.sem43.repository.BookRepository;

import java.util.List;

/**
 * Класс сервиса для управления книгами.
 */
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    /**
     * Получает все книги и сохраняет несколько новых.
     *
     * @return список всех книг
     */
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

    /**
     * Получает книгу по ее ID.
     *
     * @param id ID книги для получения
     * @return книга с заданным ID
     */
    public Book getBook(long id){
        return bookRepository.findById(id);
    }

    /**
     * Добавляет книгу в список.
     */
    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void editBook(Book book) {
        bookRepository.editBook(book);
    }
    /**
     * Deletes a book by its ID.
     *
     * @param  id   the ID of the book to be deleted
     */
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

}