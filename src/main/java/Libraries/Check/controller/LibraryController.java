package Libraries.Check.controller;

import Libraries.Check.model.BookModel;
import Libraries.Check.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Libraries")
public class LibraryController {

    private final BookService bookService;

    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/ByAuthor")
    public List<BookModel> findByAuthor(@RequestParam("author") String author) {
        return bookService.findBooksByAuthor(author);
    }

    @PostMapping
    public BookModel postBook(@RequestBody BookModel book) {
        return bookService.addBook(book);
    }
}