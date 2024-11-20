package com.wipro.paytm;

import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;
import com.paypal.orders.OrdersCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/paypal")
public class PaypalController {

    @Autowired
    private PaypalService paypalService;

    @PostMapping("/create-payment")
    public String createPayment(
            @RequestParam Double total,
            @RequestParam String currency,
            @RequestParam String intent,
            @RequestParam String description,
            Model model) {
        try {
            // Pass in the URLs for success and cancellation
            String cancelUrl = "http://localhost:8080/paypal/cancel";
            String successUrl = "http://localhost:8080/paypal/success";

            // Call the service to create payment
            HttpResponse<Order> response = paypalService.createPayment(total, currency, intent, description, cancelUrl, successUrl);

            // Redirect to PayPal approval URL
            String approvalLink = response.result().links().stream()
                    .filter(link -> "approve".equals(link.rel()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Approval link not found.")) // Use RuntimeException for unchecked exception
                    .href();

            return "redirect:" + approvalLink;
        } catch (IOException e) {
            // Handle IOException
            model.addAttribute("errorMessage", "Error creating payment: " + e.getMessage());
            return "error"; // Return an error page
        } catch (RuntimeException e) {
            // Handle RuntimeException for approval link not found
            model.addAttribute("errorMessage", e.getMessage());
            return "error"; // Return an error page
        }
    }

    @GetMapping("/success")
    public String paymentSuccess(@RequestParam("token") String token, @RequestParam("PayerID") String payerId, Model model) {
        // Optionally capture the payment here
        model.addAttribute("message", "Payment completed successfully!");
        return "success"; // Return the name of your success.html page
    }

    @GetMapping("/cancel")
    public String paymentCancel(Model model) {
        model.addAttribute("message", "Payment was canceled.");
        return "cancel"; // Return the name of your cancel.html page
    }
}
