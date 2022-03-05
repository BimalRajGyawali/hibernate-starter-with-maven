package me.personal.repo;

import me.personal.entity.Customer;

import java.util.List;

public interface CustomerRepo {

    Long save(Customer customer);

    Customer findById(Long id);

    List<Customer> findByFullName(String fullName);

    List<Customer> findByAddress(String address);
}
