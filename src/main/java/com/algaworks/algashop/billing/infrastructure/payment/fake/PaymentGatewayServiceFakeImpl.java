package com.algaworks.algashop.billing.infrastructure.payment.fake;

import com.algaworks.algashop.billing.domain.model.invoce.PaymentMethod;
import com.algaworks.algashop.billing.domain.model.invoce.payment.Payment;
import com.algaworks.algashop.billing.domain.model.invoce.payment.PaymentGatewayService;
import com.algaworks.algashop.billing.domain.model.invoce.payment.PaymentRequest;
import com.algaworks.algashop.billing.domain.model.invoce.payment.PaymentStatus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@ConditionalOnProperty(name = "algashop.integrations.payment.provider", havingValue = "FAKE")
public class PaymentGatewayServiceFakeImpl implements PaymentGatewayService {
    @Override
    public Payment capture(PaymentRequest request) {
        return Payment.builder()
                .invoiceId(request.getInvoiceId())
                .status(PaymentStatus.PAID)
                .method(request.getMethod())
                .gatewayCode(UUID.randomUUID().toString())
                .build();
    }

    @Override
    public Payment findByCode(String gatewayCode) {
        return Payment.builder()
                .invoiceId(UUID.randomUUID())
                .status(PaymentStatus.PAID)
                .method(PaymentMethod.GATEWAY_BALANCE)
                .gatewayCode(UUID.randomUUID().toString())
                .build();
    }
}
