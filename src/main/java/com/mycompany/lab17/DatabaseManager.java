/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class DatabaseManager {

    private static final String DATABASE_URL = "jdbc:sqlite:src/main/resources/LibrarySystem.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public static void addBook(Book book) {
        String sql = "INSERT INTO books(name, author, stock) VALUES(?, ?, ?)";

        try (Connection connection = getConnection(); PreparedStatement pstatement = connection.prepareStatement(sql)) {

            pstatement.setString(1, book.getName());
            pstatement.setString(2, book.getAuthor());
            pstatement.setInt(3, book.getStock());
            pstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void initialize() {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS books ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "author TEXT NOT NULL,"
                + "stock INTEGER NOT NULL)";

        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sqlCreateTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadBooks(Library library) {
        String sqlSelectAllBooks = "SELECT * FROM books";

        try (Connection connection = getConnection(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sqlSelectAllBooks)) {

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("stock"));
                library.addBook(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
