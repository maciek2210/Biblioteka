/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Marek
 */
public class Ksiazka {
    
    private String autor;
    private String tytul;
    private String wydanie;
    private int stron;
    private int sztuk;
    private int wolnychSztuk;
    private String gatunek;
    private int rok;
    private int id;
    private List<Wypozyczenie> wypozyczenie;
    
    
    
    

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the tytul
     */
    public String getTytul() {
        return tytul;
    }

    /**
     * @param tytul the tytul to set
     */
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    /**
     * @return the wydanie
     */
    public String getWydanie() {
        return wydanie;
    }

    /**
     * @param wydanie the wydanie to set
     */
    public void setWydanie(String wydanie) {
        this.wydanie = wydanie;
    }

    /**
     * @return the stron
     */
    public int getStron() {
        return stron;
    }

    /**
     * @param stron the stron to set
     */
    public void setStron(int stron) {
        this.stron = stron;
    }

    /**
     * @return the sztuk
     */
    public int getSztuk() {
        return sztuk;
    }

    /**
     * @param sztuk the sztuk to set
     */
    public void setSztuk(int sztuk) {
        this.sztuk = sztuk;
    }

    /**
     * @return the wolnychSztuk
     */
    public int getWolnychSztuk() {
        return wolnychSztuk;
    }

    /**
     * @param wolnychSztuk the wolnychSztuk to set
     */
    public void setWolnychSztuk(int wolnychSztuk) {
        this.wolnychSztuk = wolnychSztuk;
    }

    /**
     * @return the gatunek
     */
    public String getGatunek() {
        return gatunek;
    }

    /**
     * @param gatunek the gatunek to set
     */
    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    /**
     * @return the rok
     */
    public int getRok() {
        return rok;
    }

    /**
     * @param rok the rok to set
     */
    public void setRok(int rok) {
        this.rok = rok;
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
     * @return the uzytkownicy
     */
    public List<Wypozyczenie> getWypozyczenie() {
        return wypozyczenie;
    }

    /**
     * @param uzytkownicy the uzytkownicy to set
     */
    public void setWypozyczenie(List<Wypozyczenie> wypozyczenie) {
        this.wypozyczenie = wypozyczenie;
    }
    
    
}
