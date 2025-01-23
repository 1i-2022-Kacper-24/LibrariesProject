package Libraries.Check.controller;

import Libraries.Check.service.ShelfService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "library")
public class LibraryController {
    private ShelfService shelfService;

    public LibraryController(ShelfService shelfService) {
        this.shelfService = shelfService;
    }

}
