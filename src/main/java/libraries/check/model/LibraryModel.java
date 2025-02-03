package libraries.check.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "library")
public class LibraryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;

    @JsonBackReference
    @OneToMany(mappedBy = "library")
    private List<ShelfModel> shelves;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<ShelfModel> getShelves() {
        return shelves;
    }

    public void setShelves(List<ShelfModel> shelves) {
        this.shelves = shelves;
    }
}
