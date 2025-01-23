package Libraries.Check.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(orphanRemoval = true)
    private List<ShelfModel> shelves = new ArrayList<>();

    public CityModel() {
    }

    public CityModel(Long id, String name, List<ShelfModel> shelves) {
        this.id = id;
        this.name = name;
        this.shelves = shelves;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", shelves=" + shelves +
                '}';
    }

}
