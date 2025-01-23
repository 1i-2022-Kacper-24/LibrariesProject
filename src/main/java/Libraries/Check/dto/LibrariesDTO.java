package Libraries.Check.dto;

import Libraries.Check.model.LibraryModel;

import java.util.ArrayList;
import java.util.List;

public class LibrariesDTO {
    private List<LibraryDTO> libraries;

    public LibrariesDTO(List<LibraryDTO> libraries) {
        this.libraries = libraries;
    }

    public static LibrariesDTO fromModel(List<LibraryModel> libraries) {
        List<LibraryDTO> librariesDTO = new ArrayList<>();
        for(LibraryModel lib : libraries) {
            librariesDTO.add(LibraryDTO.fromModel(lib));
        }
        return new LibrariesDTO(librariesDTO);
    }

    public List<LibraryDTO> getLibraries() {
        return libraries;
    }
}