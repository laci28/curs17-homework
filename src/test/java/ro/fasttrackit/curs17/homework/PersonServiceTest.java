package ro.fasttrackit.curs17.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonServiceTest {
    @Test
    @DisplayName("WHEN personService is initialized with empty list THEN getPersons is empty")
    void testEmptyList() {
        //GIVEN
        PersonService personService = new PersonService(List.of());
        //WHEN
        List<Person> received = personService.getAllPersons();
        //THEN
        assertThat(received).isEmpty();
    }

    @Test
    @DisplayName("WHEN personService is initialized with some persons THEN the persons are return")
    void testNotEmptyList() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Maria", "Stanescu", 3, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<Person> received = personService.getAllPersons();
        //THEN
        assertThat(received).hasSize(2);
        assertThat(received).isEqualTo(expected);
    }

    @Test
    @DisplayName("WHEN personService.allPersonsNames THEN return the first name and last name")
    void testAllPersonsNames() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Maria", "Stanescu", 3, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<String> received = personService.allPersonsNames();
        //THEN
        assertThat(received).isEqualTo(List.of("Maria Stanescu", "Ionel Istrate"));
    }

}
