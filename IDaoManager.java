/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import model.Ksiazka;
import model.Uzytkownik;

/**
 *
 * @author Marek
 */
public interface IDaoManager {
    
    public DaoResult addBook(Ksiazka ksiazka);
    public DaoResult updateBook(Ksiazka ksiazka);
    public Connection getConnection();
    public DaoResult getBooks();
    public DaoResult getBook(Integer id);
    public DaoResult addUser(Uzytkownik u);
    public DaoResult login(Uzytkownik u) ;
    public DaoResult lentBook(Ksiazka _ksiazka);
    public DaoResult deleteBook(Ksiazka _ksiazka);
    
}
