package ro.fasttrackit.curs17.homework;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public PersonService(Collection<Person> persons) {
        if (persons != null) {
            this.persons.addAll(persons);
        }
    }

    public Map<String, String> allPersonsNames() {
        return persons.stream()
                .collect(Collectors.toMap(Person::getFirstName, Person::getLastName));
    }

    public Map<String, String> majorPersons() {
        return persons.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toMap(Person::getFirstName, Person::getLastName));
    }

    public Map<String, String> personsFromOradea() {
        return persons.stream()
                .filter(person -> person.getCity().equals("Oradea"))
                .collect(Collectors.toMap(Person::getFirstName,
                        Person::getLastName));
    }

    public Map<String, String> personsFromOradeaOrCluj() {
        return persons.stream()
                .filter(person -> person.getCity().equals("Oradea") ||
                        person.getCity().equals("Cluj"))
                .collect(Collectors.toMap(Person::getFirstName,
                        Person::getLastName));
    }

    public List<String> firstNameCapitalized() {
        return persons.stream()
                .map(person -> person.getFirstName().toUpperCase())
                .collect(Collectors.toList());
    }

    public Map<String, Object> firstLetter() {
        return persons.stream()
                .collect(Collectors.toMap(Person::getFirstName,
                        person -> person.getLastName().charAt(0)));
    }

    public Map<String, String> personsBetween18And60() {
        return persons.stream()
                .filter(person -> person.getAge() > 17 && person.getAge() < 61)
                .collect(Collectors.toMap(Person::getFirstName, Person::getLastName));
    }

    public List<String> firstNameWithA() {
        return persons.stream()
                .filter(person -> person.getFirstName().startsWith("A"))
                .map(Person::getFirstName)
                .collect(Collectors.toList());
    }

    public List<String> allFirstNamesUniquely() {
        return persons.stream()
                .map(Person::getFirstName)
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, String> sortByFirstName() {
        return persons.stream()
                .collect(Collectors.toMap(Person::getFirstName, Person::getLastName));
    }

    public Map<String, String> sortByLastName() {
        return persons.stream()
                .collect(Collectors.toMap(Person::getLastName, Person::getFirstName));
    }

    public List<Person> sortByFirstNameLastNameAndAge() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getFirstName))
                .collect(Collectors.toList());
    }
}
