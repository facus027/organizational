/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.organizational.entidad;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

@Entity
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String name;
    private String email;
 
    
    private Integer points;
     
     
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mission_id")
    @Nullable
    private Mission now;
    
    @OneToMany(cascade = CascadeType.ALL)
    @Nullable
    private List<Mission> last;
    
   
    
    
    
    
}
