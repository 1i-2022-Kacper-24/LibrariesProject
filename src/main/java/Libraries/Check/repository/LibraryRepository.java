package Libraries.Check.repository;

import Libraries.Check.model.LibraryModel;
import Libraries.Check.model.ShelfModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryModel, Long> {
    LibraryModel findByShelvesContains(ShelfModel shelf);
}
