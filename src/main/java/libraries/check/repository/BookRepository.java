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
    /*  Search by any of parameters:
        author - not null - text before passing should be checked for null
        title - not null - text before passing should be checked for null
        publicationYear - number
        publicationIndicator - number that is setting how we search by publicationYear:
                                (publicationIndicator > 0) greater than publicationYear
                                (publicationIndicator = 0) equal to publicationYear
                                (publicationIndicator < 0) less than publicationYear
        numberOfPages - number
        pagesIndicator - number that is setting how we search by numberOfPages:
                                (pagesIndicator > 0) greater than numberOfPages
                                (pagesIndicator = 0) equal to numberOfPages
                                (pagesIndicator < 0) less than numberOfPages
    */
    @Query(value = "SELECT b FROM BookModel b " +
            "WHERE LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%')) " +
                "AND LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%')) " +
                "AND (:publicationYear IS NULL OR :publicationIndicator IS NULL " +
                    "OR (:publicationIndicator > 0 AND b.pubYear > :publicationYear) " +
                    "OR (:publicationIndicator = 0 AND b.pubYear = :publicationYear) " +
                    "OR (:publicationIndicator < 0 AND b.pubYear < :publicationYear)) " +
                "AND (:numberOfPages IS NULL OR :pagesIndicator IS NULL " +
                    "OR (:pagesIndicator > 0 AND b.pages > :numberOfPages) " +
                    "OR (:pagesIndicator = 0 AND b.pages = :numberOfPages) " +
                    "OR (:pagesIndicator < 0 AND b.pages < :numberOfPages))"
    )
    List<BookModel> findAllByParameters(@Param("author")String author,
                                        @Param("title")String title,
                                        @Param("publicationYear") Integer publicationYear,
                                        @Param("publicationIndicator") Integer publicationIndicator,
                                        @Param("numberOfPages") Integer numberOfPages,
                                        @Param("pagesIndicator") Integer pagesIndicator
                                        );

}
