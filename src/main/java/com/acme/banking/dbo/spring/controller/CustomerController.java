package com.acme.banking.dbo.spring.controller;

import com.acme.banking.dbo.spring.dao.AccountRepository;
import com.acme.banking.dbo.spring.domain.Account;
import com.acme.banking.dbo.spring.domain.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(path = "/api", headers = "X-API-VERSION")
@Validated
@Api(value = "Customers", description = "Operations on Customers of DBO")
public class CustomerController {
    //    @Autowired private ObjectMapper objectMapper;
    @Autowired
    private Logger logger;

    @GetMapping(path = "/customers", headers = "X-API-VERSION=1")
    @ApiOperation(value = "View a list of all customers", response = Collection.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public ArrayList<Customer> getAllCustomers() {

        Customer customer1 = new Customer("Customer1");
        Customer customer2 = new Customer("Customer2");
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer1);
        customerList.add(customer2);
//        Collection<Customer> customerList = new Collection<Customer>() {
        return customerList;
    }

    /**
     * @param id is @Valid out-of-box by using @Validated annotation for Controller class
     */
    @GetMapping(path = "/customers/{id}", headers = "X-API-VERSION=1")
    public ResponseEntity<Customer> getCustomer(@PathVariable @PositiveOrZero(message = "No negative id!") long id) {
        return new ResponseEntity<>(new Customer("Customer1"), HttpStatus.FOUND);
    }

    @DeleteMapping(path = "/customers/{id}", headers = "X-API-VERSION=1")
    public ResponseEntity<?> deleteCustomer(@PathVariable @PositiveOrZero(message = "No negative id!") long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/customers", headers = "X-API-VERSION=1")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer) {
        return new ResponseEntity<Customer>(new Customer(customer.getName()), HttpStatus.CREATED);
    }
}
