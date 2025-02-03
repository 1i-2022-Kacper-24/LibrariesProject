package libraries.check.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "shelf")
public class ShelfModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shelfNumber;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "library_id")
    private LibraryModel library;

    @OneToMany(mappedBy = "shelf")
    private List<BookModel> books;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(Long shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public LibraryModel getLibrary() {
        return library;
    }

    public void setLibrary(LibraryModel library) {
        this.library = library;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
