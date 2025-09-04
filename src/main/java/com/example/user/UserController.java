@RestController
@RequestMapping("/users")
public class UserController {
    private List<Map<String, Object>> users = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

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
                .filter(u -> u.get("id").equals(id))
                .findFirst()
                .orElse(null);
    }
}
