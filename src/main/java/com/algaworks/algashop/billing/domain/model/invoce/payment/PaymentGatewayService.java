package com.algaworks.algashop.billing.domain.model.invoce.payment;


/*ACL que utiliza a propria linguagem do dominio */
public interface PaymentGatewayService {
    Payment capture(PaymentRequest request);
    Payment findByCode(String gatewayCode);
}
