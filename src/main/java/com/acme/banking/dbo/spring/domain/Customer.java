package com.acme.banking.dbo.spring.domain;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

//@Entity //TODO JPA Entity semantics
//@ApiModel(subTypes = {SavingAccount.class, CheckingAccount.class})
//@Entity //TODO JPA Entity semantics
//@Inheritance @DiscriminatorColumn(name="ACCOUNT_TYPE")
//@JsonPropertyOrder({ "id", "type", "email", "amount" }) //TODO Jackson annotations semantics: https://www.baeldung.com/jackson-annotations & https://github.com/FasterXML/jackson-annotations
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = SavingAccount.class, name = "S"),
//        @JsonSubTypes.Type(value = CheckingAccount.class, name = "C")
//})
public class Customer {
    /** TODO Validation Framework */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @PositiveOrZero private long id;
    @Size(max = 50) private String name;

    /** No-arg constructor needed by JPA */
    public Customer() { }

    public Customer(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /** TODO Mutable state */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return getName().equals(customer.getName());
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + getName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getName();
    }
}
