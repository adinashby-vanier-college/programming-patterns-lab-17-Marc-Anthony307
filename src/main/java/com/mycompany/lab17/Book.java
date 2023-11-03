/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab17;

import java.util.Objects;

/**
 *
 * @author Marc-Anthony
 */
public class Book {

    private String name;
    private String author;
    private int stock;

    public Book() {

    }

    public Book(String name, String author, int stock) {
        this.name = name;
        this.author = author;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        final Book other = (Book) obj;
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.author, other.author);
    }


    @Override
    public String toString() {
        return "Book: " + this.name + "\nAuthor: " + this.author + "\nStock: " + this.stock + "\n\n";
    }

}
