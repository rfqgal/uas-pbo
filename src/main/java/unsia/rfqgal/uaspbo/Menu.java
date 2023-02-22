/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unsia.rfqgal.uaspbo;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rfqgal
 */
public class Menu {
    
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     *  Define menu for main
     */
    public static void getMenu() {
        System.out.println("-- Menu Aplikasi --");
        
        System.out.println("1. Tambahkan barang");
        System.out.println("2. Daftar barang");
        System.out.println("3. Edit barang");
        System.out.println("4. Hapus barang");
        System.out.println("5. Keluar");
        
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        
        switch (pilihan) {
            case 1 -> createProduct();
            case 2 -> listProduct();
            case 3 -> editProduct();
            case 4 -> deleteProduct();
            case 5 -> System.exit(0);
            default -> throw new AssertionError();
        }
    }
    
    /**
     *  Create Product
     */
    public static void createProduct() {
        System.out.println("\n-- Menambahkan Barang --");
        
        System.out.print("Input nama barang: ");
        String name = scanner.next();
        
        System.out.print("Input jumlah barang: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Input harga barang: ");
        int price = scanner.nextInt();
        
        String created = Product.store(name, quantity, price);
        System.out.println("\n" + created);
        
        System.out.println("Kembali ke menu\n");
        getMenu();
    }
    
    /**
     *  List Product
     */
    public static void listProduct() {
        List products = Product.index();
        
        System.out.println("\n-- Menampilkan Daftar Barang --");
        System.out.println("| ID\t| Nama\t| Qty\t| Harga\t|");
        System.out.println("-\t-\t-\t-\t-");
        for (Object product : products) {
            System.out.println(product);
        }
        
        System.out.println("\nKembali ke menu\n");
        getMenu();
    }
    
    /**
     *  Edit Product
     */
    public static void editProduct() {
        System.out.println("\n-- Mengedit Barang --");
        
        System.out.print("Input id barang: ");
        int id = scanner.nextInt();
        
        System.out.print("Input nama barang: ");
        String name = scanner.next();
        
        System.out.print("Input jumlah barang: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Input harga barang: ");
        int price = scanner.nextInt();
        
        String edited = Product.update(id, name, quantity, price);
        System.out.println("\n" + edited);
        
        System.out.println("Kembali ke menu\n");
        getMenu();
    }
    
    /**
     *  Delete Product
     */
    public static void deleteProduct() {
        System.out.println("\n-- Menghapus Barang --");
        
        System.out.print("Input id barang: ");
        int id = scanner.nextInt();
        
        String deleted = Product.destroy(id);
        System.out.println("\n" + deleted);
        
        System.out.println("Kembali ke menu\n");
        getMenu();
    }
}
