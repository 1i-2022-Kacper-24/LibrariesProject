package libraries.check.service;

import libraries.check.dto.LibraryDTO;
import libraries.check.model.BookModel;
import libraries.check.model.LibraryModel;
import libraries.check.model.ShelfModel;
import libraries.check.repository.LibraryRepository;
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

    public List<LibraryDTO> getAllLibraries() {
        return libraryRepository.findAll().stream().map(LibraryDTO::fromModel).toList();
    }

    public List<LibraryModel> getLibraryWithShelfByBook(List<BookModel> books) {
        return libraryRepository.findAllByShelves_Books_IdIn(
                books.stream()
                .map(BookModel::getId)
                .collect(Collectors.toUnmodifiableList()));
    }
}
