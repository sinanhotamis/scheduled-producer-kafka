package com.snnlab.scheduledproducerkafka.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfoDTO {

    private String id;
    private BigDecimal amount;
    private String currency;

}
