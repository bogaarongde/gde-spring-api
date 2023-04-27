package hu.gde.alkfelj.gdespringapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final GreetingRepository repository;

    @Autowired
    public GreetingController(GreetingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/savegreeting")
    public Greeting saveGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        GreetingEntity entity = repository.save(new GreetingEntity(new Greeting(counter.incrementAndGet(), String.format(template, name))));
        return new Greeting(entity.getId(), entity.getContent());
    }
}
