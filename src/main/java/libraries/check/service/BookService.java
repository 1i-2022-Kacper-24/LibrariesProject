package libraries.check.service;

import libraries.check.dto.BookFoundDTO;
import libraries.check.model.BookModel;
import libraries.check.model.LibraryModel;
import libraries.check.model.ShelfModel;
import libraries.check.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final LibraryService libraryService;

    @Autowired
    public BookService(BookRepository bookRepository, LibraryService libraryService) {
        this.bookRepository = bookRepository;
        this.libraryService = libraryService;
    }

    public BookModel addBook(BookModel book) {
        return bookRepository.save(book);
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookFoundDTO> search(String author, String title, Integer pubYear, Integer publicationIndicator, Integer pages, Integer pagesIndicator, String cityName, Long shelfNumber) {
        String authorParam = author != null ? author : "";
        String titleParam = title != null ? title : "";
        String cityParam = cityName != null ? cityName : "";
        return bookRepository.findAllByParameters(authorParam, titleParam, pubYear, publicationIndicator, pages, pagesIndicator, cityParam, shelfNumber);
    }

}