package ir.moke.module.micronaut.resource;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import ir.moke.module.micronaut.entity.Book;
import ir.moke.module.micronaut.repository.PersonRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Controller("/person")
public class PersonResources {

    @Inject
    private PersonRepository repository;

    @Post
    public Book add(@Body Book book) {
        repository.save(book);
        return book;
    }

    @Get("/add")
    public Book addCustom() {
        Book book = new Book("aaa");
        repository.save(book);
        return book;
    }

    @Get("/{id}")
    public Optional<Book> person(Long id) {
        return repository.findById(id);
    }

    @Get("/all")
    public List<Book> getAll() {
        return repository.findAll();
    }
}
