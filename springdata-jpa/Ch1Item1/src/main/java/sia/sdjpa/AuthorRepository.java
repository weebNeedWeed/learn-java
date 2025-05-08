package sia.sdjpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Query("select a from Author a left join fetch a.books where a.name = :name")
    Author fetchByName(String name);
}
