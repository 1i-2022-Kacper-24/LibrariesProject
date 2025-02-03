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

    public List<BookFoundDTO> search(String author, String title, Integer pubYear, Integer publicationIndicator, Integer pages, Integer pagesIndicator) {
        List<BookModel> books = new ArrayList<>();

        books = findAllBooksByParameters(author, title, pubYear, publicationIndicator, pages, pagesIndicator);

        List<LibraryModel> librariesWithShelvesWithBooks = libraryService.getLibraryWithShelfByBook(books);
        List<BookFoundDTO> booksFound = new ArrayList<>();
        for(LibraryModel library : librariesWithShelvesWithBooks) {
            for(ShelfModel shelf : library.getShelves()) {
                for(BookModel book : shelf.getBooks()) {
                    if(books.contains(book)) {
                        booksFound.add(BookFoundDTO.fromModel(book, library, shelf));
                    }
                }
            }
        }
        return booksFound;
    }

    public List<BookModel> findAllBooksByParameters(String author, String title, Integer pubYear, Integer publicationIndicator, Integer pages, Integer pagesIndicator) {
        String authorParam = author != null ? author : "";
        String titleParam = title != null ? title : "";
        return bookRepository.findAllByParameters(authorParam, titleParam, pubYear, publicationIndicator, pages, pagesIndicator);
    }

}