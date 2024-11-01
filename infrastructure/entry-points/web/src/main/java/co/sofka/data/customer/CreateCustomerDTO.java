package co.sofka.data.customer;

public class CreateCustomerDTO {

    private String name;

    public CreateCustomerDTO(String name) {
        this.name = name;
    }

    public CreateCustomerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
