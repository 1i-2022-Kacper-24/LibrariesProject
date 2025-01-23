package Libraries.Check.service;

import Libraries.Check.model.BookModel;
import Libraries.Check.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public BookModel addBook(BookModel book) {
        return bookRepository.save(book);
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
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


}