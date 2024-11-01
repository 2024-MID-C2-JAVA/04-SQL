package co.sofka.usecase.customer;

import co.sofka.Customer;
import co.sofka.gateway.GetByIdRepository;

public class GetCustomerByIdUseCase {

    private final GetByIdRepository<Customer>repository;


    public GetCustomerByIdUseCase(GetByIdRepository<Customer> repository) {
        this.repository = repository;
    }

    public Customer apply(Customer customer) {
        return repository.getById(customer);
    }
}
