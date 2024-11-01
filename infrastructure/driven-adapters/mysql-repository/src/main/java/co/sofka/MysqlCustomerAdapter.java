package co.sofka;

import co.sofka.config.MysqlCustomerRepository;
import co.sofka.data.CustomerEntity;
import co.sofka.exceptions.InvalidNameCustomerException;
import co.sofka.gateway.CreateRepository;
import co.sofka.gateway.DeleteRepository;
import co.sofka.gateway.GetByIdRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class MysqlCustomerAdapter implements CreateRepository<Customer>, DeleteRepository<Customer>, GetByIdRepository<Customer> {

    private final MysqlCustomerRepository repository;

    public MysqlCustomerAdapter(MysqlCustomerRepository repository) {
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
        repository.save(entity);
    }



    @Override
    public void delete(Customer customer) {
        CustomerEntity entity=new CustomerEntity();
        entity.setId(Integer.parseInt(customer.getId()));
        repository.delete(entity);
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
