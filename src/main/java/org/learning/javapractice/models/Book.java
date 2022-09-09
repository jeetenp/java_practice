package org.learning.javapractice.models;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {
    int id;
    String name, author, publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, publisher, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && quantity == book.quantity && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher);
    }
}