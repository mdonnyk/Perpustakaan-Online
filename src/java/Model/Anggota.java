/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Michael Donny Kusuma
 */
public class Anggota {
    private String id;
    private String nama;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }    
    
//    public static void tambahAnggota(Anggota a){
//        Connection conn = null;
//        PreparedStatement ps = null;       
//        conn = DatabaseManager.getDBConnection();
//             try{
//                 ps = conn.prepareCall("INSERT INTO BUKU VALUES(?,?,?,?,?,?)");
//                 ps.setString(1, b.getIsbn());
//                 ps.setString(2, b.getJudul());
//                 ps.setString(3, b.penulis);
//                 ps.setInt(4, b.getTahun());
//                 ps.setString(5, b.penerbit);
//                 ps.setInt(6, b.getKetersediaan());
//                 ps.executeUpdate();
//                 conn.commit();
//             }
//             catch(SQLException ex){
//             }
//             finally{
//                 try{
//                     ps.close();
//                     conn.close();}
//                 catch (SQLException ex){
//                 }
//             }
//    }
    

}
