package Libraries.Check.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "Book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private int pubYear;
    private int pages;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "", nullable = true)
//    @JsonBackReference
//    private ShelfModel shelf;


    public BookModel() {}

    public BookModel(String author, String title, int pubYear, int pages) {
        this.author = author;
        this.title = title;
        this.pubYear = pubYear;
        this.pages = pages;
    }

    // Gettery i settery
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

}