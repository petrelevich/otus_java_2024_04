package ru.otus.neo4jdemo.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhoneUser {
    private String id;
    private String name;

    private List<Phone> phones;
}
