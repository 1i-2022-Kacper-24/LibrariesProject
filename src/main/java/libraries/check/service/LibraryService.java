package libraries.check.service;

import libraries.check.dto.LibraryDTO;
import libraries.check.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<LibraryDTO> getAllLibraries() {
        return libraryRepository.findAll().stream().map(LibraryDTO::fromModel).toList();
    }

}
