package com.example.product;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
    private final List<Map<String, Object>> products = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public Map<String, Object> addProduct(@RequestBody Map<String, Object> product) {
        product.put("id", counter.incrementAndGet());
        products.add(product);
        return product;
    }

    @GetMapping
    public List<Map<String, Object>> getProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getProduct(@PathVariable Long id) {
        return products.stream()
                .filter(p -> Objects.equals(p.get("id"), id))
                .findFirst()
                .orElse(null);
    }
}
