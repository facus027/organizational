/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.organizational.entidad;

import com.example.organizational.enumeraciones.Tarea;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.lang.Nullable;

@Entity
@Data
public class Mission {
    
    @Id
    private Integer id;
    
    private String name;
    private String detail;
    
    @Temporal(TemporalType.DATE) 
    @Nullable
    private Date deadline;
    
    @Temporal(TemporalType.DATE)
    private Date repeat;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    @Nullable
    private Usuario user;
    
    @Enumerated(EnumType.STRING)
    private Tarea type;
    
}
