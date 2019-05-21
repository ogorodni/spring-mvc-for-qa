package com.acme.banking.dbo.spring.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
@ApiModel(parent = Account.class, discriminator = "type")
public class SavingAccount extends Account {
    public SavingAccount() { }

    public SavingAccount(double amount, String email) {
        super(amount, email);
    }

    @Override
    @ApiModelProperty(allowableValues = "S")
    public String getType() {
        return "S";
    }
}
