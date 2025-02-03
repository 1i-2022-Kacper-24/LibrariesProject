package libraries.check.dto;

import libraries.check.model.LibraryModel;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {
    private String cityName;
    private List<ShelfDTO> shelfList = new ArrayList<>();

    public LibraryDTO() {
    }

    public LibraryDTO(String cityName, List<ShelfDTO> shelfList) {
        this.cityName = cityName;
        this.shelfList = shelfList;
    }

    public LibraryModel toModel() {
        LibraryModel libraryModel = new LibraryModel();
        libraryModel.setCityName(cityName);
        return libraryModel;
    }

    public static LibraryDTO fromModel(LibraryModel libraryModel) {
        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setCityName(libraryModel.getCityName());
        libraryDTO.setShelfList(libraryModel.getShelves().stream().map(ShelfDTO::fromModel).toList());
        return libraryDTO;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<ShelfDTO> getShelfList() {
        return shelfList;
    }

    public void setShelfList(List<ShelfDTO> shelfList) {
        this.shelfList = shelfList;
    }
}
