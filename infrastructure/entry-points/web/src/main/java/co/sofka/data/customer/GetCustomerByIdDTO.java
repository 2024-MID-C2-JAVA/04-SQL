package co.sofka.data.customer;

public class GetCustomerByIdDTO {

    private String id;

    public GetCustomerByIdDTO() {
    }

    public GetCustomerByIdDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
