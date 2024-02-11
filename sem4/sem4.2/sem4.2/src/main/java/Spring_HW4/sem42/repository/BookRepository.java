package Spring_HW4.sem42.repository;

import Spring_HW4.sem42.models.Book;
import org.springframework.stereotype.Component;

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

    public Book save(Book user) {
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        books.put(user.getId(), user);
        return user;
    }
}
