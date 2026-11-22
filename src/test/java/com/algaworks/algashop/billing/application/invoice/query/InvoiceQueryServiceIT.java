package com.algaworks.algashop.billing.application.invoice.query;

import com.algaworks.algashop.billing.application.AbstractApplicationIT;

import com.algaworks.algashop.billing.domain.model.invoce.Invoice;
import com.algaworks.algashop.billing.domain.model.invoce.InvoiceRepository;
import com.algaworks.algashop.billing.domain.model.invoce.PaymentMethod;
import com.algaworks.algashop.billing.domain.model.invoice.InvoiceTestDataBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class InvoiceQueryServiceIT extends AbstractApplicationIT {

    @Autowired
    private InvoiceQueryService invoiceQueryService;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    public void shouldFindByOrderId() {
        Invoice invoice = InvoiceTestDataBuilder.anInvoice().build();
        invoice.changePaymentSetting(PaymentMethod.GATEWAY_BALANCE, null);
        invoiceRepository.saveAndFlush(invoice);
        InvoiceOutput invoiceOutput = invoiceQueryService.findByOrderId(invoice.getOrderId());

        Assertions.assertThat(invoiceOutput.getId()).isEqualTo(invoice.getId());

    }

}