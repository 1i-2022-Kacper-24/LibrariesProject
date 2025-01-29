package libraries.check.repository;

import libraries.check.model.BookModel;
import libraries.check.model.ShelfModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends JpaRepository<ShelfModel, Long> {
    ShelfModel findByBooksContains(BookModel book);
}
