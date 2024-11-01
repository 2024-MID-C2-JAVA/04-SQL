package co.sofka.usecase.customer;

import co.sofka.Customer;
import co.sofka.gateway.DeleteRepository;

public class DeleteCustomerUseCase {

    private final DeleteRepository<Customer>repository;

    public DeleteCustomerUseCase(DeleteRepository<Customer> repository) {
        this.repository = repository;
    }

    public void apply(Customer customer) {
        repository.delete(customer);
    }
}
