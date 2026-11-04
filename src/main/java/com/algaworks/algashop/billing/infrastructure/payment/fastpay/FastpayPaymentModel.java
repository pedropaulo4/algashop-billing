package com.algaworks.algashop.billing.infrastructure.payment.fastpay;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
public class FastpayPaymentModel {

    private String id;
    private String referenceCode;
    private String status;
    private String method;
    private String totalAmount;
}
