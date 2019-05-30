package com.acme.banking.dbo.spring.it;

import com.acme.banking.dbo.spring.dao.AccountRepository;
import com.acme.banking.dbo.spring.dao.CustomerRepository;
import com.acme.banking.dbo.spring.domain.Customer;
import com.acme.banking.dbo.spring.domain.SavingAccount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
//TODO @SpringBootTest VS @WebMvcTest(MyController.class): focus only on the web layer and not start a complete ApplicationContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) //TODO Semantics of MOCK: No servlet container started
@AutoConfigureMockMvc
public class CustmerControllerIT {

    @Autowired private MockMvc mockMvc; //TODO Exception handling issue: https://github.com/spring-projects/spring-boot/issues/7321#issuecomment-261343803
    @Autowired private Logger logger;
    @MockBean private CustomerRepository customers; //TODO MockBean semantics
    //TODO If not @SpringBootTest use @TestExecutionListeners(MockitoTestExecutionListener.class)
    //TODO @SpyBean semantics

    public Customer customerStub = new Customer("Name1");


    @Test
    public void shouldGetNoCustomersWhenCustomersRepoIsEmpty() throws Exception {
        when(customers.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/customers").header("X-API-VERSION", "1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.length()").value("0"));
    }

    @Test
    public void shouldGetTheOneCustomerWhenRepoIsPrePopulated() throws Exception {

        when(customers.findAll()).thenReturn(asList(customerStub));

        mockMvc.perform(get("/api/customers").header("X-API-VERSION", "1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.length()").value("1"))
                .andExpect(jsonPath("$[0].name").value("Name1"));
    }

    @Test
    public void shouldGetTheCustomerByIdWhenRepoIsPrePopulated() throws Exception {
        when(customers.findById(new Long(0))).thenReturn(java.util.Optional.of(customerStub));

        mockMvc.perform(get("/api/customers/0").header("X-API-VERSION", "1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Name1"));
    }

    @Test
    public void shouldPostTheCustomer() throws Exception {

        mockMvc.perform(post("/api/customers").header("X-API-VERSION", "1").content("{\"id\":0,\"name\":\"Name1\"}"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Name1"));
    }

    @Test
    public void shouldDeleteTheCustomerByIdWhenRepoIsPrePopulated() throws Exception {
       // when(customers.deleteById(new Long(0))).thenReturn());

        mockMvc.perform(delete("/api/customers/0").header("X-API-VERSION", "1"))
                .andExpect(status().is2xxSuccessful());

    }

}
