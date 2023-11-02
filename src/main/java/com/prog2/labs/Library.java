/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marc-Anthony
 */
public class Library implements LibraryObservable {

    private List<LibraryObserver> observers = new ArrayList<>();
    private static Library lObject;
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();

    }

    public static Library getInstance() {    //Singleton design pattern
        if (lObject == null) {
            lObject = new Library();

        }
        return lObject;
    }

    public void addBook(Book book) {

        books.add(book);
        notifyObservers();  //notify the observers when a new book is added

    }

    public void registerObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LibraryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (LibraryObserver observer : observers) {
            observer.update();  //this is responsible for updating the booksTextBox in the MainForm, using it's update() method
        }
    }

    public static Library getlObject() {
        return lObject;
    }

    public static void setlObject(Library lObject) {
        Library.lObject = lObject;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Library other = (Library) obj;
        return Objects.equals(this.books, other.books);
    }

    @Override
    public String toString() {
        return books.toString();
    }

}
