/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.organizational.entidad;

import com.example.organizational.enumeraciones.Categoria;
import com.example.organizational.enumeraciones.State;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Data
public class Product {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String name;
    
    @Enumerated(EnumType.STRING)
    private State state;
    
    @Enumerated(EnumType.STRING)
    private Categoria category;
    
    private Boolean order;
    
}
