/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.organizational.repositorio;

import com.example.organizational.entidad.Product;
import com.example.organizational.entidad.Refri;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RefriRepositorio extends JpaRepository<Refri, String> {
    
  @Query("SELECT r FROM Refri r WHERE r.lastOrder = :lastOrder")
  public Refri filterByDeadline(@Param("lastOrder") Date lastOrder);
    
    
}
