package co.sofka.data.transaction;

public class GetTransactionDTO {

    private String id;

    public GetTransactionDTO(String id) {
        this.id = id;
    }

    public GetTransactionDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
