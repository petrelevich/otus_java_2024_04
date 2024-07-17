package ru.otus.neo4jdemo.repository;

import java.util.List;
import java.util.Optional;
import ru.otus.neo4jdemo.model.Phone;

public interface PhoneRepository {
    void insert(Phone phone);

    Optional<Phone> findOne(String id);

    List<Phone> findAll();

    List<Phone> findAllByUserId(String userId);
}
