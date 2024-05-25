package ir.moke.module.jersey.model;

import java.util.Objects;

public class Person {
    private Long id;
    private String name;
    private String family;

    public Person() {
    }

    public Person(Long id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
