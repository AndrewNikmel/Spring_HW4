package spring_HW4.sem43.repository;

import org.springframework.stereotype.Component;
import spring_HW4.sem43.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class BookRepository {
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public Book findById(long id) {
        return books.get(id);
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(counter.incrementAndGet());
        }
        books.put(book.getId(), book);
        return book;
    }



    public void deleteById (long id) {
        books.remove(id);
    }

    public void editBook(Book book) {
        if (book != null && book.getId() != null) {
            // Проверяем, существует ли книга с таким ID
            Book existingBook = findById(book.getId());
            if (existingBook != null) {
                // Обновляем данные книги
                existingBook.setName(book.getName());
                existingBook.setAuthor(book.getAuthor());
                save(existingBook);
            }
        }
    }
}
