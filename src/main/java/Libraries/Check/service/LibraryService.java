package Libraries.Check.service;

import Libraries.Check.model.BookModel;
import Libraries.Check.model.LibraryModel;
import Libraries.Check.model.ShelfModel;
import Libraries.Check.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public LibraryModel getLibraryByShelf(ShelfModel shelf) {
        return libraryRepository.findByShelvesContains(shelf);
    }

    public List<LibraryModel> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public List<LibraryModel> getLibraryWithShelfByBook(List<BookModel> books) {
        return libraryRepository.findAllByShelves_Books_IdIn(
                books.stream()
                .map(BookModel::getId)
                .collect(Collectors.toUnmodifiableList()));
    }
}
