/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2283429
 */
public class Lab17 {

    public static void main(String[] args) {
        try {
            DatabaseManager.initialize();
            
//            DatabaseManager.clearBooks();

//            Book newBook = new Book("Harry Potter", "JK Rowling", 45);
//            DatabaseManager.addBook(newBook);

            Library library = Library.getInstance();
            DatabaseManager.loadBooks(library);

            MainForm mainForm = new MainForm();
            LibraryController libraryController = new LibraryController(library, mainForm);
            mainForm.setLibraryController(libraryController); 

            libraryController.updateView();
            
            mainForm.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace(); // This will print any exceptions that occur
        }
    }

    
}
