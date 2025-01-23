package Libraries.Check.repository;

import Libraries.Check.model.BookModel;
import Libraries.Check.model.ShelfModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends JpaRepository<ShelfModel, Long> {
    ShelfModel findByBooksContains(BookModel book);
}
