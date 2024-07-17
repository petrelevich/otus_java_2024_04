package ru.otus.neo4jdemo.repository;

import java.util.List;
import java.util.Optional;
import ru.otus.neo4jdemo.model.PhoneUser;

public interface PhoneUserRepository {
    void insert(PhoneUser phoneUser);

    Optional<PhoneUser> findOne(String id);

    List<PhoneUser> findAll();
}
