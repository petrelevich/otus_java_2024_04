package ru.otus.cassandrademo.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SmartPhone {
    private UUID id;
    private String model;
    private String color;
    private String serialNumber;

    private String operatingSystem;
}
