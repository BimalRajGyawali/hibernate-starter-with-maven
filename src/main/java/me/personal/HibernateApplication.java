package me.personal;

import me.personal.entity.Customer;
import me.personal.repo.CustomerRepo;
import me.personal.repo.CustomerRepoImpl;

public class HibernateApplication {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate");

        CustomerRepo customerRepo = new CustomerRepoImpl();

        var savedCustomerId = customerRepo.save(
                new Customer()
                        .fullName("Ram")
                        .address("Lalitpur")
        );

        System.out.println(savedCustomerId);

        System.out.println(customerRepo.findById(11L));

        System.out.println(customerRepo.findByFullName("John"));

        System.out.println(customerRepo.findByAddress("KTM"));
    }
}
