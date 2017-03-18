/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Buku;

/**
 *
 * @author Michael Donny Kusuma
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Test Database
        //DatabaseManager.getDBConnection();
        
        //Test Input
//        Buku b = new Buku();
//        b.setIsbn("123456789013");
//        b.setJudul("Data Mining");
//        b.setPenulis("Bambang Budiman");
//        b.setTahun(1996);
//        b.setPenerbit("Sanata Dharma");
//        b.setKetersediaan(3);
//        Buku.inputBuku(b);


        //Test Cari
        Buku[] bu = Buku.cariBuku("123456789012");
        for (int i = 0; i < bu.length; i++) {
            System.out.println(bu[i].getJudul());
        }


        //System.out.println(Buku.testCari(""));
    }
    
}
