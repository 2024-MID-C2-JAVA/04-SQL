package com.example.banco_hex_yoder.postgresql_repository.data.repositorios;


import com.example.banco_hex_yoder.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
