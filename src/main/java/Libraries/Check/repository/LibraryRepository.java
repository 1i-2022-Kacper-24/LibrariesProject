package Libraries.Check.repository;

import Libraries.Check.model.LibraryModel;
import Libraries.Check.model.ShelfModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryModel, Long> {
    LibraryModel findByShelvesContains(ShelfModel shelf);
    List<LibraryModel> findAllByShelves_Books_IdIn(List<Long> ids);
}
