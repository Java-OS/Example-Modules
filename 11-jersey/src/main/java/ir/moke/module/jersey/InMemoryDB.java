package ir.moke.module.jersey;

import ir.moke.module.jersey.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class InMemoryDB {
    public static final InMemoryDB instance = new InMemoryDB();
    private static final Logger logger = LoggerFactory.getLogger(InMemoryDB.class);
    private static final Set<Person> PERSON_LIST = new HashSet<>();

    private InMemoryDB() {
    }

    public void init() {
        logger.info("Initialize DB");
        PERSON_LIST.add(new Person(1L, "Ali", "Hashemi"));
        PERSON_LIST.add(new Person(2L, "Mohammad", "Ebrahimi"));
        PERSON_LIST.add(new Person(3L, "Mahdi", "Sani"));
    }

    public void add(Person person) {
        long id = PERSON_LIST.isEmpty() ? 1 : PERSON_LIST.stream().toList().getLast().getId() + 1;
        person.setId(id);
        PERSON_LIST.add(person);
    }

    public void update(Person person) {
        PERSON_LIST.removeIf(item -> item.getId().equals(person.getId()));
        add(person);
    }

    public void remove(Person person) {
        PERSON_LIST.remove(person);
    }

    public Person find(long id) {
        return PERSON_LIST.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public Set<Person> findAll() {
        return PERSON_LIST;
    }
}
