package com.wipro.paytm;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PaypalConfig {

    @Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    @Value("${paypal.mode:sandbox}") // default to sandbox if not set
    private String mode;

    @Bean
    public PayPalEnvironment paypalEnvironment() {
        // Use the correct environment based on the mode
        if ("sandbox".equalsIgnoreCase(mode)) {
            return new PayPalEnvironment.Sandbox(clientId, clientSecret);
        } else if ("live".equalsIgnoreCase(mode)) {
            return new PayPalEnvironment.Live(clientId, clientSecret);
        } else {
            throw new IllegalArgumentException("Invalid PayPal mode: " + mode + ". Use 'sandbox' or 'live'.");
        }
    }

    @Bean
    public PayPalHttpClient payPalHttpClient() {
        // Create a new PayPalHttpClient with the defined environment
        return new PayPalHttpClient(paypalEnvironment());
    }
}
