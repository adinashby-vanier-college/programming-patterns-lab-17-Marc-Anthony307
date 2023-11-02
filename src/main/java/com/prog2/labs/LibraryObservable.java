/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prog2.labs;

/**
 *
 * @author Marc-Anthony
 */
public interface LibraryObservable {

    void registerObserver(LibraryObserver observer);

    void removeObserver(LibraryObserver observer);

    void notifyObservers();
}
