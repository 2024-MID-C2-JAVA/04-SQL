package co.sofka.usecase.customer;

import co.sofka.Customer;
import co.sofka.exceptions.InvalidCreationException;
import co.sofka.exceptions.InvalidNameCustomerException;
import co.sofka.gateway.CreateRepository;

public class CreateCustomerUseCase {

    private final CreateRepository<Customer>repository;

    public CreateCustomerUseCase(CreateRepository<Customer> repository) {
        this.repository = repository;
    }

    public void apply(Customer customer) {

        if(customer == null) {
            throw new InvalidCreationException("Customer cannot be null");
        }

        if(customer.getName().equals(" ") || customer.getName() == null){
            throw new InvalidNameCustomerException("The customer name must not be empty or null");
        }

        repository.create(customer);
    }
}
