package ir.moke.module.micronaut.resource;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import ir.moke.module.micronaut.model.Person;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller("/person")
@Produces()
public class PersonResources {
    private static final List<Person> PERSON_LIST = new ArrayList<>();

    @PostConstruct
    public void init() {
        PERSON_LIST.add(new Person(1L, "Ali", "bagheri"));
        PERSON_LIST.add(new Person(2L, "Mohammadi", "Hashemi"));
        PERSON_LIST.add(new Person(3L, "Mahdi", "Hosseini"));
    }

    @Get("/{id}")
    public Person person(Long id) {
        return PERSON_LIST.stream().filter(item -> Objects.equals(item.id(), id)).findFirst().orElse(null);
    }

    @Get("/all")
    public List<Person> getAll() {
        return PERSON_LIST;
    }
}
