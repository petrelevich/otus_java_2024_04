package ru.otus.cassandrademo.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Phone {
    private UUID id;
    private String model;
    private String color;
    private String serialNumber;
}
