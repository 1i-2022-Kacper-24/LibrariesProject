package libraries.check.repository;

import libraries.check.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {
    List<BookModel> findByAuthor(String author);
    List<BookModel> findByTitle(String title);
    List<BookModel> findByPubYear(int pubYear);
    List<BookModel> findByPages(int pages);
    List<BookModel> findByPagesGreaterThan(int pages);
    List<BookModel> findByPagesLessThan(int pages);
}
