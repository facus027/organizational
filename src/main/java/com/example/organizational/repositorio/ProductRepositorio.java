/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.organizational.repositorio;

import com.example.organizational.entidad.Product;
import com.example.organizational.enumeraciones.Categoria;
import com.example.organizational.enumeraciones.State;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositorio extends JpaRepository<Product,String> {
    
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    public Product filterByName(@Param("name") String name);
    
    @Query("SELECT p FROM Product p WHERE p.state = :state")
    public List<Product> filterByState(@Param("state") State state);
    
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    public List<Product> filterByCate(@Param("category") Categoria category);
    
   @Query("SELECT p FROM Product p WHERE p.order = :order")
    public List<Product> filterByOrder(@Param("order") Boolean order);
    
        
}
