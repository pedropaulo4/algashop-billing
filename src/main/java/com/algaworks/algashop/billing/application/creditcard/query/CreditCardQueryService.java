package com.algaworks.algashop.billing.application.creditcard.query;

import com.algaworks.algashop.billing.domain.model.creditcard.CreditCard;

import java.util.List;
import java.util.UUID;

public interface CreditCardQueryService {

    CreditCardOutput findOne(UUID customerId, UUID creditCardId);
    List<CreditCardOutput> findByCustomer(UUID customerId);
}
