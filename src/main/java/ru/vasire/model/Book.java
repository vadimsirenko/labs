package ru.vasire.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;

    @NotEmpty(message = "Поле наименование обязательное")
    @Size(min = 2, max = 100, message = "Поле наименование должно содержать от 2 до 100 символов")
    private String name;

    @NotEmpty(message = "Поле автор обязательное")
    @Size(min = 2, max = 100, message = "Поле автор должно содержать от 2 до 100 символов")
    private String author;

    @Min(value = 1900, message = "Значение года публикации должно быть больше 1900")
    private int publication;

    private Integer personId;
    private String personName;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Book(String name, String author, int publication) {
        this.name = name;
        this.author = author;
        this.publication = publication;
    }

    public Book() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publication=" + publication +
                ", personId=" + personId +
                '}';
    }
}
