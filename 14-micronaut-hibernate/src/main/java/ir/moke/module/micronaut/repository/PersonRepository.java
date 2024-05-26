package ir.moke.module.micronaut.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import ir.moke.module.micronaut.entity.Book;

@Repository
public interface PersonRepository extends CrudRepository<Book, Long> {
}
