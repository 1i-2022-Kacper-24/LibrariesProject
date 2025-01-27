package Libraries.Check.controller;

  
import Libraries.Check.dto.LibrariesDTO;
import Libraries.Check.model.LibraryModel;
import Libraries.Check.service.LibraryService;
import Libraries.Check.service.ShelfService;
import Libraries.Check.model.BookModel;
import Libraries.Check.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/library")
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
    public List<BookModel> searchBooks(
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "pubYear", required = false) Integer pubYear,
            @RequestParam(value = "pages", required = false) Integer pages,
            @RequestParam(value = "pagesIndicator", required = false, defaultValue = "0") int pagesIndicator){
        return bookService.search(author,title,pubYear,pages,pagesIndicator);
    }

    @PostMapping
    public BookModel postBook(@RequestBody BookModel book) {
        return bookService.addBook(book);
    }
}
