package Libraries.Check.controller;

import Libraries.Check.dto.LibrariesDTO;
import Libraries.Check.service.LibraryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public LibrariesDTO getAllLibraries() {
        return (LibrariesDTO) LibrariesDTO.fromModel(libraryService.getAllLibraries());
    }

}
