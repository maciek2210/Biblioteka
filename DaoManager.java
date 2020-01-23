/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ksiazka;
import model.Uzytkownik;
import model.Wypozyczenie;

/**
 *
 * @author Marek
 */
public class DaoManager extends ConnectionManager implements IDaoManager {

    @Override
    public DaoResult addBook(Ksiazka ksiazka) {
        
        String sql = "INSERT INTO ksiazki(id,autor,tytul,rok,wydanie,sztuk,stron,gatunek) VALUES(?,?,?,?,?,?,?,?)";
 
        try{
            PreparedStatement pstmt = getConnection().prepareStatement(sql) ;
            pstmt.setNull(1, 0);
            pstmt.setString(2, ksiazka.getAutor());
            pstmt.setString(3, ksiazka.getTytul());
            pstmt.setInt(4, ksiazka.getRok());
            pstmt.setString(5, ksiazka.getWydanie());
            pstmt.setInt(6, ksiazka.getSztuk());
            pstmt.setInt(7, ksiazka.getStron());
            pstmt.setString(8, ksiazka.getGatunek());
            
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        return new DaoResult("Dodano pozycję pomyślnie");
        
    }

    @Override
    public DaoResult updateBook(Ksiazka ksiazka) {
        
        String sql = "update ksiazki set autor=?,tytul=?,rok=?,wydanie=?,sztuk=?,stron=?,gatunek=? where id=?";
 
        try{
            PreparedStatement pstmt = getConnection().prepareStatement(sql) ;
          
            pstmt.setString(1, ksiazka.getAutor());
            pstmt.setString(2, ksiazka.getTytul());
            pstmt.setInt(3, ksiazka.getRok());
            pstmt.setString(4, ksiazka.getWydanie());
            pstmt.setInt(5, ksiazka.getSztuk());
            pstmt.setInt(6, ksiazka.getStron());
            pstmt.setString(7, ksiazka.getGatunek());
            pstmt.setInt(8, ksiazka.getId());
            
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        return new DaoResult("Uaktualniono pozycję pomyślnie");
        
    }
    
    public DaoResult getBooks() {

        DaoResult result=new DaoResult();
        
        String sql="Select * from ksiazki";
        
        try{
             Statement stmt  = getConnection().createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
            
             List<Ksiazka> ksiazki=new ArrayList<Ksiazka>();
             
            // loop through the result set
            while (rs.next()) {
              Ksiazka ks=new Ksiazka();
              parseKsiazka(ks,rs);
              
              ksiazki.add(ks);
            }
            result.setObject(ksiazki);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        return result;
        
    }

    public DaoResult getBook(Integer id) {
        
           DaoResult result=new DaoResult();
           
        try {
            String sql="select k.sztuk - count(w.idKsiazki) stan,k.* from ksiazki k left join  wypozyczenia w on k.id=w.idKsiazki and w.zwrocone=0 where k.id="+id;
            Statement stmt  = getConnection().createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            Ksiazka ks=new Ksiazka();
            parseKsiazka(ks,rs);
            ks.setWolnychSztuk(rs.getInt("stan"));
            rs.close();
            
            try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            pobierzWypozyczenia(ks);
            
            result.setObject(ks);
                                    
        } catch (SQLException ex) {
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         return result;
    }

    private void parseKsiazka(Ksiazka ks, ResultSet rs) throws SQLException {
              ks.setAutor(rs.getString("autor"));
              ks.setTytul(rs.getString("tytul"));
              ks.setWydanie(rs.getString("wydanie"));
              ks.setSztuk(rs.getInt("sztuk"));
              ks.setId(rs.getInt("id"));
              ks.setRok(rs.getInt("rok"));
              ks.setStron(rs.getInt("stron"));
              ks.setGatunek(rs.getString("gatunek"));
    }

    public DaoResult addUser(Uzytkownik u) {
        
         String sql = "INSERT INTO uzytkownicy(id,login, imieNazwisko,dataUrodzenia,haslo,mail) VALUES(?,?,?,?,?,?)";
 
        try{
            PreparedStatement pstmt = getConnection().prepareStatement(sql) ;
            pstmt.setNull(1, 0);
            pstmt.setString(2, u.getLogin());
            pstmt.setString(3, u.getImieNazwisko());
            pstmt.setDate(4, new java.sql.Date(u.getDataUrodzenia().getTime()));
            pstmt.setString(5, u.getHaslo());
            pstmt.setString(6, u.getMail());
           
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return new DaoResult("Dodano pozycję pomyślnie");
    }

    public DaoResult login(Uzytkownik u) {
          DaoResult result=new DaoResult();
           
        try {
         
            
            String sql="Select count(*) logged, id from uzytkownicy where login='"+u.getLogin()+"' and haslo='"+u.getHaslo()+"'";
            Statement stmt  = getConnection().createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            if(rs.getInt("logged")>0){
                u.setId(rs.getInt("id"));
                return new DaoResult(false,"Zalogowano",u);
                
            }else{
                return new DaoResult(true,"Nieprawidłowy login lub hasło");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         return result;
    
    }

    public DaoResult lentBook(Ksiazka _ksiazka) {
        String sql = "INSERT INTO wypozyczenia(id,idUzytkownika, idKsiazki,data,zwrocone) VALUES(?,?,?,?,?)";
 
        try{
            PreparedStatement pstmt = getConnection().prepareStatement(sql) ;
            pstmt.setNull(1, 0);
            pstmt.setInt(2, session.Session.user.getId());
            pstmt.setInt(3, _ksiazka.getId());
            
            pstmt.setDate(4, new Date((new java.util.Date()).getTime()));
            pstmt.setBoolean(5, false);
                   
            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return new DaoResult("Wypożyczono książkę pomyślnie");
    }

    private void pobierzWypozyczenia(Ksiazka ks) {
         try {
            ks.setWypozyczenie(new ArrayList<>());
             
            String sql="select id,idUzytkownika,data from wypozyczenia where zwrocone=0 and idKsiazki="+ks.getId();
            Statement stmt  = getConnection().createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            
           
            
             while (rs.next()) {
                 Wypozyczenie w=new  Wypozyczenie();
                 w.setData(rs.getDate("data"));
                 w.setUzytkownik(getUser(rs.getInt("idUzytkownika")));
                 w.setId(rs.getInt("id"));
                 ks.getWypozyczenie().add(w);
              
             }
                                    
        } catch (SQLException ex) {
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Uzytkownik getUser(int id) {
        
        Uzytkownik u=new Uzytkownik();
        
          try {
           
            String sql="select *  from uzytkownicy  where id="+id;
            Statement stmt  = getConnection().createStatement();
            
            ResultSet rs    = stmt.executeQuery(sql);
           if(rs.isClosed())
               return null;
            u.setDataUrodzenia(rs.getDate("dataUrodzenia"));
            u.setLogin(rs.getString("login"));
            u.setId(rs.getInt("id"));
            u.setImieNazwisko(rs.getString("imieNazwisko"));
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         return u;
        
    }

    public DaoResult returnBook(int id) {
     String sql = "update wypozyczenia set zwrocone=1 where id="+id;
 
        try{
            PreparedStatement pstmt = getConnection().prepareStatement(sql) ;
                   
            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return new DaoResult("Zwrócono książkę pomyślnie");
        
    
    }
    
      public DaoResult getRecomendations(Integer id) {
        
           DaoResult result=new DaoResult();
           
        try {
            String sql="select * from ksiazki k where k.gatunek in(" +

"select k.gatunek from ksiazki k where k.id in (" +
"select  w.idKsiazki from wypozyczenia w where w.idUzytkownika="+id+" group by w.idKsiazki order by data desc  ) and gatunek like '%true%')" +

"union " +

"select * from ksiazki k1 where k1.autor in (" +
"select k.autor from ksiazki k where k.id in (" +
"select  w.idKsiazki from wypozyczenia w where w.idUzytkownika="+id+" group by w.idKsiazki order by data desc))";
            Statement stmt  = getConnection().createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            
            List<Ksiazka> ksiazki=new ArrayList<>();
            while(rs.next()){
            Ksiazka ks=new Ksiazka();
            parseKsiazka(ks,rs);
            ksiazki.add(ks);
            
            }
            result.setObject(ksiazki);
           
            rs.close();
            if(ksiazki.size()==0){
            result.setIsError(true);
            result.setMessString("Brak rekomendacji.");
            }
            try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
           
                                    
        } catch (SQLException ex) {
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         return result;
    }

    public DaoResult deleteBook(Ksiazka _ksiazka) {
        String sql = "delete from ksiazki where id="+_ksiazka.getId();
 
        try{
            PreparedStatement pstmt = getConnection().prepareStatement(sql) ;
                   
            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return new DaoResult("Usunięto książkę pomyślnie");
    }

    public DaoResult getBooks(String tytul, String autor) {

        
        DaoResult result=new DaoResult();
        
        String sql="Select * from ksiazki where autor like '%"+autor+"%' and tytul like '%"+tytul+"%'";
        
        try{
             Statement stmt  = getConnection().createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
            
             List<Ksiazka> ksiazki=new ArrayList<Ksiazka>();
             
            // loop through the result set
            while (rs.next()) {
              Ksiazka ks=new Ksiazka();
              parseKsiazka(ks,rs);
              
              ksiazki.add(ks);
            }
            result.setObject(ksiazki);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
             try {
                 getConnection().close();
             } catch (SQLException ex) {
                 Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        return result;
        
    
    }

}
