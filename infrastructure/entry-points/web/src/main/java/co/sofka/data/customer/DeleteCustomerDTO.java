package co.sofka.data.customer;

public class DeleteCustomerDTO {

    private String id;

    public DeleteCustomerDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
