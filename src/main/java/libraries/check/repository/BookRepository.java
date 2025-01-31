package libraries.check.repository;

import libraries.check.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {
    @Query(value = "SELECT b FROM BookModel b WHERE LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))")
    List<BookModel> findByAuthor(@Param("author")String author);


    List<BookModel> findByTitle(String title);


    List<BookModel> findByPubYear(int pubYear);


    List<BookModel> findByPubYearGreaterThan(int pubYear);


    List<BookModel> findByPubYearLessThan(int pubYear);


    List<BookModel> findByPages(int pages);


    List<BookModel> findByPagesGreaterThan(int pages);


    List<BookModel> findByPagesLessThan(int pages);
}
