package com.snnlab.scheduledproducermessage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SnnLabInfoDTO implements Serializable {

    private String id;
    private BigDecimal amount;
    private String currency;

}
