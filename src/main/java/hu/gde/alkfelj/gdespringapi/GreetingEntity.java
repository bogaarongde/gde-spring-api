package hu.gde.alkfelj.gdespringapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GreetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long greetingId;

    private String content;

    public GreetingEntity() {}

    public GreetingEntity(Greeting greeting) {
        this.content = greeting.content();
    }

    public Long getId() {
        return greetingId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
