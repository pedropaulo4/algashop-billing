package com.algaworks.algashop.billing.infrastructure.payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties("algashop.integrations.payment")
@Validated
@Data
public class AlgashopPaymentProperties {

    @NotNull
    private AlgashopPaymentProvider provider;


    @NotNull
    private FastpayProperties fastpay;

    private enum AlgashopPaymentProvider {
        FAKE,
        FASTPAY
    }

    @Validated
    @Data
    public static class FastpayProperties {
        @NotBlank
        private String hostName;

        @NotBlank
        private String privateToken;

        @NotBlank
        private String webhookUrl;



    }
}
