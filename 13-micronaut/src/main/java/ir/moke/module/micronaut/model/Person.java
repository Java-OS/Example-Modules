package ir.moke.module.micronaut.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Person(Long id, String name, String family) {
}
