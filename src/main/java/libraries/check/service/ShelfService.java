package libraries.check.service;

import libraries.check.model.BookModel;
import libraries.check.model.ShelfModel;
import libraries.check.repository.ShelfRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfService {

    private ShelfRepository shelfRepository;

    public ShelfService(ShelfRepository shelfRepository) {
        this.shelfRepository = shelfRepository;
    }

    public List<ShelfModel> getAllShelves() {
        return shelfRepository.findAll();
    }

    public ShelfModel ShelfModel(BookModel book) {
        return shelfRepository.findByBooksContains(book);
    }
}
