package Libraries.Check.dto;

import Libraries.Check.model.ShelfModel;

public class ShelfDTO {
    public Long shelfNumber;

    public ShelfDTO() {
    }

    public ShelfDTO(Long shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public ShelfModel toModel() {
        ShelfModel shelfModel = new ShelfModel();
        shelfModel.setShelfNumber(shelfNumber);
        return shelfModel;
    }

    public static ShelfDTO fromModel(ShelfModel shelfModel) {
        ShelfDTO shelfDTO = new ShelfDTO();
        shelfDTO.shelfNumber = shelfModel.getShelfNumber();
        return shelfDTO;
    }

    public Long getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(Long shelfNumber) {
        this.shelfNumber = shelfNumber;
    }
}
