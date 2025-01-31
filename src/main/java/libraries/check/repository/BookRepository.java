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

    @Query(value = "SELECT b FROM BookModel b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<BookModel> findByTitle(@Param("title")String title);

    @Query(value = "SELECT b FROM BookModel b WHERE b.pubYear = :publicationYear")
    List<BookModel> findByPubYear(@Param("publicationYear") int publicationYear);

    @Query(value = "SELECT b FROM BookModel b WHERE b.pubYear > :publicationYear")
    List<BookModel> findByPubYearGreaterThan(@Param("publicationYear") int publicationYear);

    @Query(value = "SELECT b FROM BookModel b WHERE b.pubYear < :publicationYear")
    List<BookModel> findByPubYearLessThan(@Param("publicationYear") int publicationYear);

    @Query(value = "SELECT b FROM BookModel b WHERE b.pages = :numberOfPages")
    List<BookModel> findByPages(@Param("numberOfPages") int numberOfPages);

    @Query(value = "SELECT b FROM BookModel b WHERE b.pages > :numberOfPages")
    List<BookModel> findByPagesGreaterThan(@Param("numberOfPages") int numberOfPages);

    @Query(value = "SELECT b FROM BookModel b WHERE b.pages < :numberOfPages")
    List<BookModel> findByPagesLessThan(@Param("numberOfPages") int numberOfPages);
}
