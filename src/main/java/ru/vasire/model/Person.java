package ru.vasire.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "ФИО обязательно")
    @Size(min=2, max = 100, message = "ФИО должно содержать от 2 до 100 символов")
    private String name;

    @Min(value = 1900, message = "Год рождения должен быть более 1900")
    private int birthYear;


    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Birth=" + birthYear  +
                '}';
    }
}
