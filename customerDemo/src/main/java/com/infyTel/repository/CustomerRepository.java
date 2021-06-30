package com.infyTel.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.infyTel.domain.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
