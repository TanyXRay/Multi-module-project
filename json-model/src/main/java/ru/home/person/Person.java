package ru.home.person;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Person {
    private String name;
    private int age;
    private String id;
}
