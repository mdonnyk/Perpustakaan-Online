/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Michael Donny Kusuma
 */
public class Buku {
    private String isbn;
    private String judul;
    private String penulis;
    private int tahun;
    private String penerbit;
    private int ketersediaan;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getKetersediaan() {
        return ketersediaan;
    }

    public void setKetersediaan(int ketersediaan) {
        this.ketersediaan = ketersediaan;
    }
    
    public static void inputBuku(Buku b){
        Connection conn = null;
        PreparedStatement ps = null;       
        conn = DatabaseManager.getDBConnection();
             try{
                 ps = conn.prepareCall("INSERT INTO BUKU VALUES(?,?,?,?,?,?)");
                 ps.setString(1, b.getIsbn());
                 ps.setString(2, b.getJudul());
                 ps.setString(3, b.penulis);
                 ps.setInt(4, b.getTahun());
                 ps.setString(5, b.penerbit);
                 ps.setInt(6, b.getKetersediaan());
                 ps.executeUpdate();
                 conn.commit();
             }
             catch(SQLException ex){
             }
             finally{
                 try{
                     ps.close();
                     conn.close();}
                 catch (SQLException ex){
                 }
             }
     }
    
    public static Buku[] cariBuku(String query){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Buku db[] = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM BUKU WHERE (ISBN LIKE '%"+query+"%' OR PENULIS LIKE '%"+query+"%' OR PENULIS LIKE '%"+query+"%')");
            rs.next();
            db = new Buku[rs.getInt(1)];
            rs = st.executeQuery("SELECT * FROM BUKU WHERE (ISBN LIKE '%"+query+"%' OR PENULIS LIKE '%"+query+"%' OR PENULIS LIKE '%"+query+"%')");
            int index =0;
            while(rs.next()){
                db[index] = new Buku();
                db[index].setIsbn(rs.getString(1));
                db[index].setJudul(rs.getString(2));
                db[index].setPenulis(rs.getString(3));
                db[index].setTahun(rs.getInt(4));
                db[index].setPenerbit(rs.getString(5));
                db[index].setKetersediaan(rs.getInt(6));
                index++;               
            }
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());       
        }
        finally{
            try{
                rs.close();
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    return db;
    }
    
    public static void pinjamBuku(Anggota a, Buku b){
         
    }
}
