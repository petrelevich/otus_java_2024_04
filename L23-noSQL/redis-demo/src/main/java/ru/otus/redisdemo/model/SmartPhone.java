package ru.otus.redisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SmartPhone {
    private String id;
    private String model;
    private String color;
    private String serialNumber;

    private String operatingSystem;
}
