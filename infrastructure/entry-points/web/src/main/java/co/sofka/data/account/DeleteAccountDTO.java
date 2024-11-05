package co.sofka.data.account;

public class DeleteAccountDTO {

    private String id;

    public DeleteAccountDTO() {

    }

    public DeleteAccountDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
