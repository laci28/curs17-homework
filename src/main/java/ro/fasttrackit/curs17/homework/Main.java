package ro.fasttrackit.curs17.homework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Maria", "Stanescu", 3, "Cluj"),
                new Person("Ionel", "Istrate", 13, "Oradea"),
                new Person("Georgel", "Enescu", 50, "Cluj"),
                new Person("Mihai", "Anghel", 22, "Deva"),
                new Person("Carl", "Petrescu", 35, "Oradea"),
                new Person("Magdalena", "Neagu", 50, "Cluj"),
                new Person("Alexandrescu", "Pastorel", 60, "Oradea"),
                new Person("Ana", "Dumitrescu", 11, "Oradea"),
                new Person("Ana", "Teglas", 16, "Deva"),
                new Person("Ion", "Petrila", 12, "Cluj")
        );
        PersonService personService = new PersonService(persons);

        System.out.println("All persons names: " + personService.allPersonsNames());
        System.out.println("All persons that are major: " + personService.majorPersons());
        System.out.println("All persons from Oradea: " + personService.personsFromOradea());
        System.out.println("All persons from Oradea or Cluj: " + personService.personsFromOradeaOrCluj());
        System.out.println("All firstNames CAPITALIZED: " + personService.firstNameCapitalized());
        System.out.println("First name first letter from last name: " + personService.firstLetter());
        System.out.println("All persons with 18 < age < 60: " + personService.personsBetween18And60());
        System.out.println("All persons having first name starting with A: " + personService.firstNameWithA());
        System.out.println("All first names UNIQUELY: " + personService.allFirstNamesUniquely());
        System.out.println("Sort the persons by first name: " + personService.sortByFirstName());
        System.out.println("Sort the persons by last name: " + personService.sortByLastName());
        System.out.println("Sort the persons by first name, last name and then age: " + personService.sortByFirstNameLastNameAndAge());
    }
}
