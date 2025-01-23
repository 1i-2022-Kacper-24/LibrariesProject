package Libraries.Check.controller;

import Libraries.Check.service.ShelfService;
import Libraries.Check.model.BookModel;
import Libraries.Check.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "library")
public class LibraryController {
  
    private final ShelfService shelfService;
    private final BookService bookService;

    @Autowired
    public LibraryController(ShelfService shelfService, BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<BookModel> getAll() { return bookService.getAllBooks();}

    @GetMapping("/ByAuthor")
    public List<BookModel> findByAuthor(@RequestParam("author") String author) {
        return bookService.findBooksByAuthor(author);
    }

    @GetMapping("/ByTitle")
    public List<BookModel> findByTitle(@RequestParam("title") String title) {
        return bookService.findBooksByTitle(title);
    }

    @GetMapping("/ByYear")
    public List<BookModel> findByPubYear(@RequestParam("pubYear") int pubYear) {
        return bookService.findBooksByPubYear(pubYear);
    }

    @GetMapping("/ByPages")
    public List<BookModel> findByPages(@RequestParam("pages") int pages) {
        return bookService.findBooksByPages(pages);
    }

    @PostMapping
    public BookModel postBook(@RequestBody BookModel book) {
        return bookService.addBook(book);
    }
}
