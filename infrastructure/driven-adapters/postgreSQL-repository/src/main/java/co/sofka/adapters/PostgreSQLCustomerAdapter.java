package co.sofka.adapters;

import co.sofka.Customer;
import co.sofka.config.PostgreSQLCustomerRepository;
import co.sofka.data.CustomerEntity;
import co.sofka.exceptions.InvalidNameCustomerException;
import co.sofka.gateway.CreateRepository;
import co.sofka.gateway.DeleteRepository;
import co.sofka.gateway.GetByIdRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class PostgreSQLCustomerAdapter implements CreateRepository<Customer>, DeleteRepository<Customer>, GetByIdRepository<Customer> {

    private final PostgreSQLCustomerRepository repository;

    public PostgreSQLCustomerAdapter(PostgreSQLCustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Customer customer) {
        CustomerEntity entity = new CustomerEntity();

        if (customer.getName() == null || customer.getName().trim().isEmpty()) {
            throw new InvalidNameCustomerException("The customer name cannot be empty or blank");
        }

        entity.setName(customer.getName());
        entity.setCreatedAt(LocalDate.now());
        entity.setDeleted(false);
        repository.save(entity);
    }



    @Override
    public void delete(Customer customer) {
        CustomerEntity entity=repository.findById(Integer.parseInt(customer.getId())).get();
        entity.setDeleted(true);
        repository.save(entity);
    }


    @Override
    public Customer getById(Customer customer) {
        CustomerEntity entity=repository.findById(Integer.parseInt(customer.getId())).get();
        return new Customer(
                String.valueOf(entity.getId()),
                entity.getName(),
                entity.getCreatedAt()
        );
    }
}
