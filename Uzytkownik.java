/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Marek
 */
public class Uzytkownik {
 
    private String imieNazwisko;
    private String login;
    private String haslo;
    private Date dataUrodzenia;
    private List<Wypozyczenie> wypozyczenia;
    private int id;
    private String mail;

    
    
    
    

    /**
     * @return the imieNazwisko
     */
    public String getImieNazwisko() {
        return imieNazwisko;
    }

    /**
     * @param imieNazwisko the imieNazwisko to set
     */
    public void setImieNazwisko(String imieNazwisko) {
        this.imieNazwisko = imieNazwisko;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the haslo
     */
    public String getHaslo() {
        return haslo;
    }

    /**
     * @param haslo the haslo to set
     */
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    /**
     * @return the dataUrodzenia
     */
    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    /**
     * @param dataUrodzenia the dataUrodzenia to set
     */
    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    /**
     * @return the wypozyczenia
     */
    public List<Wypozyczenie> getWypozyczenia() {
        return wypozyczenia;
    }

    /**
     * @param wypozyczenia the wypozyczenia to set
     */
    public void setWypozyczenia(List<Wypozyczenie> wypozyczenia) {
        this.wypozyczenia = wypozyczenia;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    
    
    
}
