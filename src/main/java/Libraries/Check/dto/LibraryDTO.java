package Libraries.Check.dto;

import Libraries.Check.model.LibraryModel;

public class LibraryDTO {
    private String cityName;

    public LibraryDTO() {
    }

    public LibraryDTO(String cityName) {
        this.cityName = cityName;
    }

    public LibraryModel toModel() {
        LibraryModel libraryModel = new LibraryModel();
        libraryModel.setCityName(cityName);
        return libraryModel;
    }

    public static LibraryDTO fromModel(LibraryModel libraryModel) {
        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setCityName(libraryModel.getCityName());
        return libraryDTO;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
