package libraries.check.controller;

  
import libraries.check.dto.BookFoundDTO;
import libraries.check.dto.LibrariesDTO;
import libraries.check.dto.LibraryDTO;
import libraries.check.model.LibraryModel;
import libraries.check.service.LibraryService;
import libraries.check.service.ShelfService;
import libraries.check.model.BookModel;
import libraries.check.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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

    @GetMapping("/allLibraries")
    public List<LibraryDTO> getAllLibs() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/all")
    public List<BookModel> getAll() { return bookService.getAllBooks();}

    @GetMapping("/search")
    public List<BookFoundDTO> searchBooks(
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "publicationYear", required = false) Integer publicationYear,
            @RequestParam(value = "publicationIndicator", required = false, defaultValue = "0") int publicationIndicator,
            @RequestParam(value = "numberOfPages", required = false) Integer numberOfPages,
            @RequestParam(value = "pagesIndicator", required = false, defaultValue = "0") int pagesIndicator,
            @RequestParam(value = "cityName", required = false) String cityName,
            @RequestParam(value = "shelfNumber", required = false) Long shelfNumber) {
        return bookService.search(author, title, publicationYear, publicationIndicator, numberOfPages, pagesIndicator, cityName, shelfNumber);
    }

    @PostMapping
    public BookModel postBook(@RequestBody BookModel book) {
        return bookService.addBook(book);
    }

    @GetMapping("/check")
    public ResponseEntity<Void> checkLiveness(){
        try {
            List<LibraryDTO> libraries = libraryService.getAllLibraries();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatusCode.valueOf(503)).build();
        }
        return ResponseEntity.ok().build();
    }
}
