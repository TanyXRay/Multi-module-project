package ru.home.main;

import ru.home.json.WorkWithJson;
import ru.home.person.Person;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        String id = UUID.randomUUID().toString();
        WorkWithJson workWithJson = new WorkWithJson();

        Person person = Person.builder()
                .name("Json")
                .age(19)
                .id(id)
                .build();

        String json = workWithJson.toJsonString(person);
        System.out.println(json);

        workWithJson.deserializationFromJson(json);
    }
}
