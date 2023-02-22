/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unsia.rfqgal.uaspbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rfqgal
 */
public class Product {
    
    private static Connection connection = Connect.getConnection();
        
    /**
     * Store product to database
     *
     * @param name
     * @param quantity
     * @param price
     * 
     * @return String
     */
    public static String store(String name, int quantity, int price) {
        try {
            String storeSql = "INSERT INTO products (name, quantity, price) VALUES (?,?,?)";
            
            PreparedStatement insert = connection.prepareStatement(storeSql);
            insert.setString(1, name);
            insert.setInt(2, quantity);
            insert.setInt(3, price);
            insert.execute();
            
            connection.commit();
            
            return "Barang berhasil ditambahkan!";
        } catch (SQLException e) {
            return "Barang gagal ditambahkan! \nError: " + e.getMessage();
        }
    }
    
    /**
     * Get product from database
     *
     * @return List
     */
    public static List index() {
        List list = new ArrayList();
        
        try {
            String indexSql = "SELECT * FROM products";
            
            PreparedStatement index = connection.prepareStatement(indexSql);
            ResultSet result = index.executeQuery();
            
            while (result.next()) {
                String product = "| " + result.getString("id") + "\t| ";
                product += result.getString("name") + "\t| ";
                product += result.getString("quantity") + "\t|";
                product += result.getString("price") + "\t|";
                
                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            return list;
        }
    }
    
    /**
     * Update specific product by id
     *
     * @param id
     * @param name
     * @param quantity
     * @param price
     * @return
     */
    public static String update(int id, String name, int quantity, int price) {
        try {
            String updateSql = "UPDATE products SET name = ?, quantity = ?, price = ? WHERE id = " + id;
            
            PreparedStatement update = connection.prepareStatement(updateSql);
            update.setString(1, name);
            update.setInt(2, quantity);
            update.setInt(3, price);
            update.execute();
            
            connection.commit();
            
            return "Barang berhasil diubah!";
        } catch (SQLException e) {
            return "Barang gagal diubah! \nError: " + e.getMessage();
        }
    }
    
    public static String destroy(int id) {
        try {
            String destroySql = "DELETE FROM products WHERE id = " + id;
            
            PreparedStatement destroy = connection.prepareStatement(destroySql);
            destroy.execute();
            
            connection.commit();
            
            return "Barang berhasil dihapus!";
        } catch (SQLException e) {
            return "Barang gagal dihapus! \nError: " + e.getMessage();
        }
    }
}
