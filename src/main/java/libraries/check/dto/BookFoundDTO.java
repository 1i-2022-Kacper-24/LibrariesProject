package libraries.check.dto;


import libraries.check.model.BookModel;
import libraries.check.model.LibraryModel;
import libraries.check.model.ShelfModel;

public class BookFoundDTO {

    private String title;
    private String author;
    private Integer publicationYear;
    private Integer numberOfPages;
    private Long shelfNumber;
    private String cityName;

    public BookFoundDTO() {
    }

    public BookFoundDTO(String title, String author, Integer publicationYear, Integer numberOfPages, Long shelfNumber, String cityName) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
        this.shelfNumber = shelfNumber;
        this.cityName = cityName;
    }

    public static BookFoundDTO fromModel(BookModel book, LibraryModel library, ShelfModel shelf) {
        BookFoundDTO bookFoundDTO = new BookFoundDTO();
        bookFoundDTO.title = book.getTitle();
        bookFoundDTO.author = book.getAuthor();
        bookFoundDTO.publicationYear = book.getPubYear();
        bookFoundDTO.numberOfPages = book.getPages();
        bookFoundDTO.shelfNumber = shelf.getShelfNumber();
        bookFoundDTO.cityName = library.getCityName();
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
