package com.prog2.labs;

/**
 * @author adinashby
 *
 */
public class LabSeventeen {

    /**
     * Write your test code below in the main (optional).
     *
     */
    public static void main(String[] args) {
        Library library = Library.getInstance();
        library.addBook(new Book("Harry Potter", "JK Rowling", 45));

        Controller controller = Controller.getInstance();
        MainForm mainForm = new MainForm();
        controller.setMainFormView(mainForm);
        LibraryController libraryController = new LibraryController(library, mainForm);
        mainForm.setLibraryController(libraryController);
        mainForm.setVisible(true);

    }

    /**
     * Please refer to the README file for question(s) description
     */
}
