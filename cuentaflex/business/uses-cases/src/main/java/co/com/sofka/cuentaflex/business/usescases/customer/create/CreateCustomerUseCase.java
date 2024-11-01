package co.com.sofka.cuentaflex.business.usescases.customer.create;

import co.com.sofka.cuentaflex.business.drivenports.repositories.CustomerRepository;
import co.com.sofka.cuentaflex.business.models.Customer;
import co.com.sofka.shared.business.usescases.ResultWith;
import co.com.sofka.shared.business.usescases.UseCase;

public final class CreateCustomerUseCase implements UseCase<CreateCustomerRequest, ResultWith<CreateCustomerResponse>> {
    private final CustomerRepository customerRepository;

    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResultWith<CreateCustomerResponse> execute(CreateCustomerRequest request) {
        Customer addedCustomer = customerRepository.createCustomer(
                new Customer(null, request.getUsername())
        );

        CreateCustomerResponse response = new CreateCustomerResponse(
                addedCustomer.getId(),
                addedCustomer.getUsername()
        );

        return ResultWith.success(response);
    }
}