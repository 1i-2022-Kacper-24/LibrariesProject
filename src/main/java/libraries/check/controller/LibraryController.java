package libraries.check.controller;

  
import libraries.check.dto.BookFoundDTO;
import libraries.check.dto.LibrariesDTO;
import libraries.check.model.LibraryModel;
import libraries.check.service.LibraryService;
import libraries.check.service.ShelfService;
import libraries.check.model.BookModel;
import libraries.check.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "http://localhost:4200")
public class LibraryController {
  
    private final ShelfService shelfService;
    private final BookService bookService;
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService, ShelfService shelfService, BookService bookService) {
        this.libraryService = libraryService;
        this.shelfService = shelfService;
        this.bookService = bookService;
    }
  
    public LibrariesDTO getAllLibraries() {
        return (LibrariesDTO) LibrariesDTO.fromModel(libraryService.getAllLibraries());
    }

    @GetMapping("/allLibs")
    public List<LibraryModel> getAllLibs() {return libraryService.getAllLibraries();}


    @GetMapping("/all")
    public List<BookModel> getAll() { return bookService.getAllBooks();}

    @GetMapping("/search")
    public List<BookFoundDTO> searchBooks(
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "publicationYear", required = false) Integer publicationYear,
            @RequestParam(value = "publicationIndicator", required = false, defaultValue = "0") int publicationIndicator,
            @RequestParam(value = "numberOfPages", required = false) Integer numberOfPages,
            @RequestParam(value = "pagesIndicator", required = false, defaultValue = "0") int pagesIndicator){
        return bookService.search(author,title,publicationYear,publicationIndicator,numberOfPages,pagesIndicator);
    }

    @PostMapping
    public BookModel postBook(@RequestBody BookModel book) {
        return bookService.addBook(book);
    }
}
