package ru.home.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.home.person.Person;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkWithJsonTest {
    private Person person;
    private String id = UUID.randomUUID().toString();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void createPerson() {
        person = Person.builder()
                .name("Andrew")
                .age(25)
                .id(id)
                .build();
    }

    @SneakyThrows
    @Test
    @DisplayName("Тест метода проверки сериализации в json строку")
    void checkSerializationToJson() {
        String jsonExpected = "{\"name\":\"Andrew\",\"age\":25,\"id\":\"" + id + "\"}";
        String jsonActual = objectMapper.writeValueAsString(person);

        assertEquals(jsonExpected, jsonActual);
    }

    @SneakyThrows
    @Test
    @DisplayName("Тест метода проверки десериализации json строки")
    void checkDeserializationFromJson() {
        String jsonActual = "{\"name\":\"Andrew\",\"age\":25,\"id\":\"" + id + "\"}";

        Person personActual = objectMapper.readValue(jsonActual, Person.class);
        Person personExpected = person;

        assertEquals(personExpected, personActual);
    }

    @SneakyThrows
    @Test
    @DisplayName("Тест проверки совпадений полей POJO при десериализации")
    void checkFieldForDeserializationFromJson() {
        String jsonActual = "{\"name\":\"Andrew\",\"age\":25,\"id\":\"" + id + "\"}";
        Person personActual = objectMapper.readValue(jsonActual, Person.class);

        String nameExpected = "Andrew";
        int ageExpected = 25;
        String idExpected = id;

        assertEquals(ageExpected, personActual.getAge());
        assertEquals(nameExpected, personActual.getName());
        assertEquals(idExpected, personActual.getId());
    }
}
