package libraries.check.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String title;
    private int pubYear;
    private int pages;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "shelf_id")
    private ShelfModel shelf;

    public BookModel() {}

    public BookModel(String author, String title, int pubYear, int pages) {
        this.author = author;
        this.title = title;
        this.pubYear = pubYear;
        this.pages = pages;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public ShelfModel getShelf() {
        return shelf;
    }

    public void setShelf(ShelfModel shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                '}';
    }
}
