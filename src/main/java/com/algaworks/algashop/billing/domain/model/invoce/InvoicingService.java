package com.algaworks.algashop.billing.domain.model.invoce;

import com.algaworks.algashop.billing.domain.model.DomainException;
import com.algaworks.algashop.billing.domain.model.invoce.payment.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

import static com.algaworks.algashop.billing.domain.model.invoce.payment.PaymentStatus.*;

@Service
@RequiredArgsConstructor
public class InvoicingService {

    private final InvoiceRepository invoiceRepository;

    public Invoice issue(String orderId, UUID customerId, Payer payer, Set<LineItem> items) {
        if (invoiceRepository.existsByOrderId(orderId)) {
            throw new DomainException(String.format("Invoice already exists for order %s", orderId));
        }

        return Invoice.issue(orderId, customerId, payer, items);

    }

    public void assignPayment(Invoice invoice, Payment payment) {

        invoice.assignPaymentGatewayCode(payment.getGatewayCode());
        invoice.updatePaymentStatus(payment.getStatus());
    }
}
