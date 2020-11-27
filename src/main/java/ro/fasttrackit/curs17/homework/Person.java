package ro.fasttrackit.curs17.homework;

import java.util.Objects;

public class Person {
    private final String FirstName;
    private final String lastName;
    private final int age;
    private final String city;

    public Person(String firstName, String lastName, int age, String city) {
        FirstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(FirstName, person.FirstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, lastName, age, city);
    }

    @Override
    public String toString() {
        return FirstName + " " + lastName + " " + age + " " + city;
    }
}
