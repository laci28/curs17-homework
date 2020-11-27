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
    @DisplayName("WHEN personService.allPersonsNames() THEN return the first name and last name")
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

    @Test
    @DisplayName("WHEN personService.majorPersons() THEN return the all major persons")
    void testMajorPersons() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Maria", "Stanescu", 33, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<Person> received = personService.majorPersons();
        //THEN
        assertThat(received).isEqualTo(List.of(new Person("Maria", "Stanescu", 33, "Cluj")));
    }

    @Test
    @DisplayName("WHEN personService.personsFromOradea() THEN return the all persons from Oradea")
    void testPersonsFromOradea() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Maria", "Stanescu", 33, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<Person> received = personService.personsFromOradea();
        //THEN
        assertThat(received).isEqualTo(List.of(new Person("Ionel", "Istrate", 13, "Oradea")));
    }

    @Test
    @DisplayName("WHEN personService.personsFromOradeaOrCluj() THEN return the all persons from Oradea or Cluj")
    void testPersonsFromOradeaOrCluj() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Maria", "Stanescu", 33, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<Person> received = personService.personsFromOradeaOrCluj();
        //THEN
        assertThat(received).isEqualTo(List.of(
                new Person("Maria", "Stanescu", 33, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea")));
    }

    @Test
    @DisplayName("WHEN personService.firstNameCapitalized() THEN return the all first names CAPITALIZED")
    void testFirstNameCapitalized() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Maria", "Stanescu", 33, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<String> received = personService.firstNameCapitalized();
        //THEN
        assertThat(received).isEqualTo(List.of("MARIA", "IONEL"));
    }

    @Test
    @DisplayName("WHEN personService.firstLetter() THEN return a list of all person names: firstName firstletter from last name")
    void testFirstLetter() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Maria", "Stanescu", 33, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<String> received = personService.firstLetter();
        //THEN
        assertThat(received).isEqualTo(List.of("Maria S", "Ionel I"));
    }

    @Test
    @DisplayName("WHEN personService.personsBetween18And60() THEN return a list with all persons with 18 < age < 60")
    void testPersonsBetween18And60() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Maria", "Stanescu", 33, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<Person> received = personService.personsBetween18And60();
        //THEN
        assertThat(received).isEqualTo(List.of(
                new Person("Maria", "Stanescu", 33, "Cluj")));
    }

    @Test
    @DisplayName("WHEN personService.firstNameWithA() THEN return a list of all persons having first name starting with A")
    void testFirstNameWithA() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Antonia", "Stanescu", 33, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<Person> received = personService.firstNameWithA();
        //THEN
        assertThat(received).isEqualTo(List.of(
                new Person("Antonia", "Stanescu", 33, "Cluj")
        ));
    }

    @Test
    @DisplayName("WHEN personService.allFirstNamesUniquely() THEN return a list of all first names UNIQUELY")
    void testAllFirstNamesUniquely() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Maria", "Stanescu", 33, "Cluj"),
                new Person("Maria", "Costache", 60, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<String> received = personService.allFirstNamesUniquely();
        //THEN
        assertThat(received).isEqualTo(List.of("Maria", "Ionel"));
    }

    @Test
    @DisplayName("WHEN personService.sortByFirstName() THEN return a list of persons sorted by first name")
    void testSortByFirstName() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Antonia", "Stanescu", 33, "Cluj"),
                new Person("Teodor", "Mascas", 55, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<Person> received = personService.sortByFirstName();
        //THEN
        assertThat(received).isEqualTo(List.of(
                new Person("Antonia", "Stanescu", 33, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"),
                new Person("Teodor", "Mascas", 55, "Cluj")
        ));
    }

    @Test
    @DisplayName("WHEN personService.sortByLastName() THEN return a list of persons sorted by last name")
    void testSortByLasttName() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Antonia", "Stanescu", 33, "Cluj"),
                new Person("Teodor", "Mascas", 55, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<Person> received = personService.sortByLastName();
        //THEN
        assertThat(received).isEqualTo(List.of(
                new Person("Ionel", "Istrate", 13, "Oradea"),
                new Person("Teodor", "Mascas", 55, "Cluj"),
                new Person("Antonia", "Stanescu", 33, "Cluj")
        ));
    }

    @Test
    @DisplayName("WHEN personService.sortByFirstNameLastNameAndAge() THEN return a list of persons sorted by  first name, last name and then age")
    void testSortByFirstNameLastNameAndAge() {
        //GIVEN
        List<Person> expected = List.of(
                new Person("Antonia", "Stanescu", 33, "Cluj"),
                new Person("Teodor", "Mascas", 55, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"));
        PersonService personService = new PersonService(expected);
        //WHEN
        List<Person> received = personService.sortByFirstNameLastNameAndAge();
        //THEN
        assertThat(received).isEqualTo(List.of(
                new Person("Antonia", "Stanescu", 33, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"),
                new Person("Teodor", "Mascas", 55, "Cluj")
        ));
    }
}
