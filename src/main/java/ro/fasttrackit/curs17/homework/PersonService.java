package ro.fasttrackit.curs17.homework;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public PersonService(Collection<Person> persons) {
        if (persons != null) {
            this.persons.addAll(persons);
        }
    }

    public List<Person> getAllPersons() {
        return persons;
    }

    public List<String> allPersonsNames() {
        return persons.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.toList());
    }

    public List<Person> majorPersons() {
        return persons.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toList());
    }

    public List<Person> personsFromOradea() {
        return persons.stream()
                .filter(person -> person.getCity().equals("Oradea"))
                .collect(Collectors.toList());
    }

    public List<Person> personsFromOradeaOrCluj() {
        return persons.stream()
                .filter(person -> person.getCity().equals("Oradea") ||
                        person.getCity().equals("Cluj"))
                .collect(Collectors.toList());
    }

    public List<String> firstNameCapitalized() {
        return persons.stream()
                .map(person -> person.getFirstName().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<String> firstLetter() {
        return persons.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName().charAt(0))
                .collect(Collectors.toList());
    }

    public List<Person> personsBetween18And60() {
        return persons.stream()
                .filter(person -> person.getAge() > 17 && person.getAge() < 61)
                .collect(Collectors.toList());
    }

    public List<Person> firstNameWithA() {
        return persons.stream()
                .filter(person -> person.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
    }

    public List<String> allFirstNamesUniquely() {
        return persons.stream()
                .map(Person::getFirstName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Person> sortByFirstName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    public List<Person> sortByLastName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
    }

    public List<Person> sortByFirstNameLastNameAndAge() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());
    }
}
