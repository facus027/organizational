/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.organizational.repositorio;


import com.example.organizational.entidad.Mission;
import com.example.organizational.enumeraciones.Tarea;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepositorio extends JpaRepository <Mission,Integer> { 
  
    @Query("SELECT m FROM Mission m WHERE m.deadline = :deadline")
    public List<Mission> filterByDeadline(@Param("deadline") Date deadline);
    
    @Query("SELECT m FROM Mission m WHERE m.type = :type")
    public List<Mission> filterByType(@Param("type") Tarea type);
    
     @Query("SELECT m FROM Mission m WHERE m.user.name LIKE %:name%")
    public Mission filterByUserName (@Param("name") String name);
    
    
    
}

