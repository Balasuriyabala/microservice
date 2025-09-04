package com.example.user;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final List<Map<String, Object>> users = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public Map<String, Object> addUser(@RequestBody Map<String, Object> user) {
        user.put("id", counter.incrementAndGet());
        users.add(user);
        return user;
    }

    @GetMapping
    public List<Map<String, Object>> getUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable Long id) {
        return users.stream()
                .filter(u -> Objects.equals(u.get("id"), id))
                .findFirst()
                .orElse(null);
    }
}
