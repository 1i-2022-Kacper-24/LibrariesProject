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



    public List<BookFoundDTO> search(String author, String title, Integer pubYear, Integer pages, Integer pagesIndicator) {
        List<BookModel> books = new ArrayList<>();
        if (author != null && !author.isBlank()) {
            books = bookRepository.findByAuthor(author).stream().toList();
        }
        else if (title != null && !title.isBlank()) {
            books = bookRepository.findByTitle(title);
        }
        else if (pubYear != null && pubYear.describeConstable().isPresent()) {
            books = bookRepository.findByPubYear(pubYear);
        }
        else if (pages != null && pages.describeConstable().isPresent()) {
            if (pagesIndicator < 0) {
                books = bookRepository.findByPagesLessThan(pages);
            }
            else if (pagesIndicator > 0) {
                books = bookRepository.findByPagesGreaterThan(pages);
            }
            else {
                books = bookRepository.findByPages(pages);
            }
        }
        if (books.isEmpty()) {
            return new ArrayList<>();
        }
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


    public List<BookModel> findBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<BookModel> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<BookModel> findBooksByPubYear(int pubYear) {
        return bookRepository.findByPubYear(pubYear);
    }

    public List<BookModel> findBooksByPages(int pages) {
        return bookRepository.findByPages(pages);
    }

    public List<BookModel> findBooksByPagesGreaterThan(int pages) {
        return bookRepository.findByPagesGreaterThan(pages);
    }

    public List<BookModel> findBooksByPagesLessThan(int pages) {
        return bookRepository.findByPagesLessThan(pages);
    }

}