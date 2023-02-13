package ru.home.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ru.home.person.Person;

public class WorkWithJson {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String toJsonString(Person person) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error of serialization!: " + e);
        }
    }

    @SneakyThrows
    public void deserializationFromJson(String json) {
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);
    }
}