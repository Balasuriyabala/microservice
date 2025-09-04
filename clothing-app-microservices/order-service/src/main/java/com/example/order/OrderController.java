package com.example.order;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    private final List<Map<String, Object>> orders = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> order) {
        // Validate & enrich by calling other services (service-to-service communication)
        Map user = restTemplate.getForObject("http://user-service:5000/users/" + order.get("userId"), Map.class);
        Map product = restTemplate.getForObject("http://product-service:6000/products/" + order.get("productId"), Map.class);

        order.put("id", counter.incrementAndGet());
        order.put("user", user);
        order.put("product", product);
        orders.add(order);
        return order;
    }

    @GetMapping
    public List<Map<String, Object>> getOrders() {
        return orders;
    }
}
