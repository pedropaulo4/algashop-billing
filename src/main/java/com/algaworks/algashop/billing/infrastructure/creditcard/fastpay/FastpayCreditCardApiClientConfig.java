package com.algaworks.algashop.billing.infrastructure.creditcard.fastpay;

import com.algaworks.algashop.billing.infrastructure.payment.AlgashopPaymentProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class FastpayCreditCardApiClientConfig {

    @Bean
    public FastPayCreditCardAPIClient fastpayCreditCardAPIClient(RestClient.Builder builder
            , AlgashopPaymentProperties properties) {
        var fastpayProperties = properties.getFastpay();

        RestClient restClient = builder.baseUrl(fastpayProperties.getHostName())
                .requestInterceptor((((request, body, execution) -> {
                    request.getHeaders().add("Token", fastpayProperties.getPrivateToken());
                    return execution.execute(request, body);
                }))).build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builderFor(adapter).build();

        return proxyFactory.createClient(FastPayCreditCardAPIClient.class);
    }
}
