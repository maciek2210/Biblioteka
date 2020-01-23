/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Marek
 */
public class Wypozyczenie {
    
    private Uzytkownik uzytkownik;

    private Date data;
    private boolean czyZwrocona;
    private int id;

    
    
    /**
     * @return the uzytkownik
     */
    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    /**
     * @param uzytkownik the uzytkownik to set
     */
    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    
    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the czyZwrocona
     */
    public boolean isCzyZwrocona() {
        return czyZwrocona;
    }

    /**
     * @param czyZwrocona the czyZwrocona to set
     */
    public void setCzyZwrocona(boolean czyZwrocona) {
        this.czyZwrocona = czyZwrocona;
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
    
    
    
}
