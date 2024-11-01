package co.sofka.config;

import co.sofka.data.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlCustomerRepository extends JpaRepository<CustomerEntity,Integer> {
}
