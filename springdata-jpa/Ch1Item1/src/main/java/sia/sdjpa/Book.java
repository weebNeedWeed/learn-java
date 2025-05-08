package sia.sdjpa;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@Entity
@Data
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }

        if(o.getClass() != this.getClass()) {
            return false;
        }

        if(o != this) {
            return false;
        }

        return id != null && id.equals(((Book) o).id);
    }

    @Override
    public int hashCode() {
        return 2021;
    }
}
