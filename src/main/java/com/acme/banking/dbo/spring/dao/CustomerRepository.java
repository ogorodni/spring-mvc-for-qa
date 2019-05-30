package com.acme.banking.dbo.spring.dao;

import com.acme.banking.dbo.spring.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
    Collection<Customer> findByName(String name);
    /** TODO Intro to Optional class */
}
