package Libraries.Check.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class LibraryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;

    @OneToMany(orphanRemoval = true)
    private List<ShelfModel> shelves = new ArrayList<>();

    public LibraryModel() {
    }

    public LibraryModel(Long id, String cityName, List<ShelfModel> shelves) {
        this.id = id;
        this.cityName = cityName;
        this.shelves = shelves;
    }

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

    @Override
    public String toString() {
        return "CityModel{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", shelves=" + shelves +
                '}';
    }

}
