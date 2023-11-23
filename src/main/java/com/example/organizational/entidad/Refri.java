/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.organizational.entidad;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

@Entity
@Data
public class Refri {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @OneToMany(cascade = CascadeType.ALL)
    @Nullable
    private List<Product> container; 
    
    @OneToMany(cascade = CascadeType.ALL)
    @Nullable
    private List<Product> order;
    
    @Temporal(TemporalType.DATE) 
    @Nullable
    private Date lastOrder;
    
}
