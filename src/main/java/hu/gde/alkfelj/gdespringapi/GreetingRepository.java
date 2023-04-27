package hu.gde.alkfelj.gdespringapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> { }
