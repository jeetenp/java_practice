package org.learning.javapractice.memory;

import org.learning.javapractice.models.Book;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryHeapSpace {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        while(true){
            books.add(new Book(1, "", "", "", 1));
        }
    }

}
