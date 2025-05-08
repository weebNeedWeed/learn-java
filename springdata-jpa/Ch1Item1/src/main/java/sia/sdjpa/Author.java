package sia.sdjpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private int age;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }

    public void removeBooks() {
        Iterator<Book> iterator = books.iterator();

        while(iterator.hasNext()){
            Book b = iterator.next();

            b.setAuthor(null);
            iterator.remove();
        }
    }
}
