package co.sofka.data.account;

public class GetAccountByIdDTO {

    private String id;

    public GetAccountByIdDTO(String id) {
        this.id = id;
    }

    public GetAccountByIdDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
