package com.wipro.paytm;

import com.paypal.orders.*;
import com.paypal.http.HttpResponse;
import com.paypal.http.exceptions.HttpException;
import com.paypal.core.PayPalHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaypalService {

    private static final Logger logger = LoggerFactory.getLogger(PaypalService.class);

    @Autowired
    private PayPalHttpClient payPalHttpClient;

    public HttpResponse<Order> createPayment(Double total, String currency, String intent, String description, String cancelUrl, String successUrl) throws IOException {
        // Build OrderRequest
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.checkoutPaymentIntent(intent);

        // Set the purchase unit with amount and currency
        List<PurchaseUnitRequest> purchaseUnits = new ArrayList<>();
        PurchaseUnitRequest purchaseUnit = new PurchaseUnitRequest()
                .description(description)
                .amountWithBreakdown(new AmountWithBreakdown()
                        .currencyCode(currency)
                        .value(String.format("%.2f", total))
                );
        purchaseUnits.add(purchaseUnit);
        orderRequest.purchaseUnits(purchaseUnits);

        // Set application context with cancel and return URL
        ApplicationContext applicationContext = new ApplicationContext()
                .cancelUrl(cancelUrl)
                .returnUrl(successUrl);
        orderRequest.applicationContext(applicationContext);

        // Create OrderRequest with necessary data
        OrdersCreateRequest request = new OrdersCreateRequest().requestBody(orderRequest);

        // Send the request to PayPal
        try {
            HttpResponse<Order> response = payPalHttpClient.execute(request);
            // Log the status code and order details
            logger.info("Payment created successfully. Status Code: {}", response.statusCode());
            logger.info("Order ID: {}", response.result().id()); // Accessing order ID
            return response;
        } catch (HttpException e) {
            logger.error("Error creating PayPal order: {}", e.getMessage(), e);
            throw new IOException("Error creating PayPal order: " + e.getMessage(), e);
        }
    }

    public HttpResponse<Order> capturePayment(String orderId) throws IOException {
        // Build the request to capture the order
        OrdersCaptureRequest request = new OrdersCaptureRequest(orderId);

        // Send the request to PayPal
        try {
            HttpResponse<Order> response = payPalHttpClient.execute(request);
            // Log the status code and order details
            logger.info("Payment captured successfully. Status Code: {}", response.statusCode());
            logger.info("Captured Order ID: {}", response.result().id()); // Accessing order ID
            return response;
        } catch (HttpException e) {
            logger.error("Error capturing PayPal order: {}", e.getMessage(), e);
            throw new IOException("Error capturing PayPal order: " + e.getMessage(), e);
        }
    }
}
