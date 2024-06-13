package ru.otus.builder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class BigObject2 {
    String param1;
    String param2;
    String param3;
    String param4;
    String param5;
}
