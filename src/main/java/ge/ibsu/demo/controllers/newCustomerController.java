package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class newCustomerController {

    // Dummy customer data for demonstration purposes
    private List<Customer> customers = List.of(
            new Customer("John", "Doe", "123 Main St", "New York", "USA"),
            new Customer("Jane", "Smith", "456 Elm St", "Los Angeles", "USA"),
            // Add more customers here
    );

    @GetMapping("/customers")
    public List<Customer> getCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, customers.size());

        if (startIndex >= endIndex) {
            return List.of();
        }

        return customers.subList(startIndex, endIndex);
    }
}
