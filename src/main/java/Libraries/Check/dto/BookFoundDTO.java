package Libraries.Check.dto;


import Libraries.Check.model.BookModel;
import Libraries.Check.model.LibraryModel;
import Libraries.Check.model.ShelfModel;

public class BookFoundDTO {

    private String title;
    private String author;
    private Integer publicationYear;
    private Integer numberOfPages;
    private Long shelfNumber;
    private String city;

    public BookFoundDTO() {
    }

    public BookFoundDTO(String title, String author, Integer publicationYear, Integer numberOfPages, Long shelfNumber, String city) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
        this.shelfNumber = shelfNumber;
        this.city = city;
    }

    public static BookFoundDTO fromModel(BookModel book, LibraryModel library, ShelfModel shelf) {
        BookFoundDTO bookFoundDTO = new BookFoundDTO();
        bookFoundDTO.title = book.getTitle();
        bookFoundDTO.author = book.getAuthor();
        bookFoundDTO.publicationYear = book.getPubYear();
        bookFoundDTO.numberOfPages = book.getPages();
        bookFoundDTO.shelfNumber = shelf.getShelfNumber();
        bookFoundDTO.city = library.getCityName();
        return bookFoundDTO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Long getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(Long shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
