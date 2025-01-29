package libraries.check.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shelf")
public class ShelfModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long shelfNumber;
  
    @OneToMany(orphanRemoval = false)
    private List<BookModel> books = new ArrayList<>();

    public ShelfModel() {
    }


    public ShelfModel(Long id, Long shelfNumber) {
        this.id = id;
        this.shelfNumber = shelfNumber;
    }
  
  //

    public ShelfModel(Long id, Long shelfNumber, List<BookModel> books) {
        this.id = id;
        this.shelfNumber = shelfNumber;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//
    public Long getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(Long shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return "ShelfModel{" +
                "id=" + id +
//
                ", shelfNumber=" + shelfNumber +
                ", books=" + books +
                '}';
    }
}
