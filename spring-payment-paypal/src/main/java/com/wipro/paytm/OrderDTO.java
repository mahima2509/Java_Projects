package com.wipro.paytm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private double price;         // Total amount for the payment
    private String currency;      // Currency code (e.g., "USD")
    private String description;   // Description of the order

    // Manually added getters (if Lombok is not working)
    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }
}
