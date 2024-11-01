package co.sofka.handler;

import co.sofka.Customer;
import co.sofka.data.customer.CreateCustomerDTO;
import co.sofka.data.customer.CustomerResponseDTO;
import co.sofka.data.customer.DeleteCustomerDTO;
import co.sofka.data.customer.GetCustomerByIdDTO;
import co.sofka.usecase.customer.CreateCustomerUseCase;
import co.sofka.usecase.customer.DeleteCustomerUseCase;
import co.sofka.usecase.customer.GetCustomerByIdUseCase;
import org.springframework.stereotype.Component;

@Component
public class CustomerHandler {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;

    public CustomerHandler(CreateCustomerUseCase createCustomerUseCase, DeleteCustomerUseCase deleteCustomerUseCase, GetCustomerByIdUseCase getCustomerByIdUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.deleteCustomerUseCase = deleteCustomerUseCase;
        this.getCustomerByIdUseCase = getCustomerByIdUseCase;
    }

    public void createCustomer(CreateCustomerDTO createCustomerDTO) {
        Customer customer = new Customer();
        customer.setName(createCustomerDTO.getName());
        createCustomerUseCase.apply(customer);
    }

    public void deleteCustomer(DeleteCustomerDTO deleteCustomerDTO) {
        Customer customer = new Customer();
        customer.setId(deleteCustomerDTO.getId());
        deleteCustomerUseCase.apply(customer);
    }

    public CustomerResponseDTO getCustomerById(GetCustomerByIdDTO getCustomerByIdDTO) {
        Customer customer = getCustomerByIdUseCase.apply(new Customer(getCustomerByIdDTO.getId()));
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getCreatedAt()
        );
    }

}
