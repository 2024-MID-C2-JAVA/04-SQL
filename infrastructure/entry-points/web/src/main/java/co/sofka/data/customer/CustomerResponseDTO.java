package co.sofka.data.customer;

import java.time.LocalDate;
import java.util.Date;

public class CustomerResponseDTO {

    private String id;
    private String name;
    private LocalDate createdAt;

    public CustomerResponseDTO(String id, String name, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public CustomerResponseDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
