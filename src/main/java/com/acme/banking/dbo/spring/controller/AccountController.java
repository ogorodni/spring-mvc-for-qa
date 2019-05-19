package com.acme.banking.dbo.spring.controller;

import com.acme.banking.dbo.spring.dao.AccountRepository;
import com.acme.banking.dbo.spring.domain.Account;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api", headers = "X-API-VERSION")
@Validated
@Api(value="Accounts", description="Operations on Accounts of DBO")
public class AccountController {
    @Resource private AccountRepository accounts;

    @GetMapping(value = "/accounts", headers = "X-API-VERSION=1")
    @ApiOperation(value = "View a list of all accounts", response = Collection.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public Collection<Account> getAllAccounts() {
        return accounts.findAll();
    }

    /**
     * @param id is @Valid out-of-box by using @Validated annotation for Controller class
     */
    @GetMapping(value = "/accounts/{id}", headers = "X-API-VERSION=1")
    public ResponseEntity<Account> getAccount(@PathVariable @PositiveOrZero(message = "No negative id!") long id) {
        return accounts.findById(id)
                .map(account -> new ResponseEntity<>(account, HttpStatus.FOUND))
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Account not found id: " + id
                ));
    }
}
