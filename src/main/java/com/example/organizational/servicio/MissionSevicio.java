/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.organizational.servicio;

import com.example.organizational.entidad.Mission;
import com.example.organizational.entidad.Usuario;
import com.example.organizational.enumeraciones.Tarea;
import com.example.organizational.exception.MiException;
import com.example.organizational.repositorio.MissionRepositorio;
import com.example.organizational.repositorio.UsuarioRepositorio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionSevicio {
    
    @Autowired
    private MissionRepositorio mr;
    @Autowired
    private UsuarioRepositorio ur;
    
    @Transactional
    public Mission create(Mission mission) throws MiException{
        validar(mission);
        
        return mr.save(mission);
     
    }
    
    @Transactional
    public Mission update(Integer idMission,Mission mission) throws MiException{
        
        validar(mission);
        
        Optional<Mission> respMiss=mr.findById(idMission);
        
        if(respMiss.isPresent()){
            
            Mission mi=respMiss.get();
            
            mi.setName(mission.getName());
            mi.setDetail(mission.getDetail());
            mi.setRepeat(mission.getRepeat());
            
            return mr.save(mi);
        }
        throw new MiException("Imposible modificar la tarea");
    }
    
    @Transactional
    public Mission updateDeadLine(Integer idMission,String Sdeadline) throws MiException, ParseException{
    
        
        Optional<Mission> respMiss=mr.findById(idMission);
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd"); 
        Date deadline = formato.parse(Sdeadline);
        
        if(respMiss.isPresent()){
            
            Mission mi=respMiss.get();
                
             validar(mi);
             
            mi.setDeadline(deadline);
            
            return mr.save(mi);
        }
        throw new MiException("Imposible modificar la tarea");
    }
    
    @Transactional
    public Mission updateUser(Integer idMission,String idUser) throws MiException{
    
        
        Optional<Mission> respMiss=mr.findById(idMission);
        Optional<Usuario> respUser=ur.findById(idUser);
        
        if(respMiss.isPresent() && respUser.isPresent()){
            
            Mission mi=respMiss.get();
            Usuario user=respUser.get();
            
             validar(mi);
          
        if(user.getNow()==null){
             mi.setUser(respUser.get());
        }     

            return mr.save(mi);
        }
        throw new MiException("Imposible modificar la tarea");
    }
    
    @Transactional
    public void delete(Integer idMi) throws MiException{
       
        Optional<Mission>respMiss=mr.findById(idMi);
        
        if(respMiss.isPresent()){
            mr.deleteById(idMi);
        }
        throw new MiException("La tarea es imposible de eliminar");
                
    }
     
    public List<Mission> getAll(){
        return mr.findAll();
    }
    
    public List<Mission> getAllDeadLine(String Sdeadline ) throws ParseException{
        
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd"); 
        Date deadline = formato.parse(Sdeadline);
        
        return mr.filterByDeadline(deadline);
    }
    
     public List<Mission> getAllType(Tarea type){
         
         return mr.filterByType(type);
     }
    
    public Mission getOne(Integer idMission){
        return mr.getOne(idMission);
    }
    
     public Mission getOneUserName(String name){
        return mr.filterByUserName(name);
    }
    
    public void validar(Mission mission) throws MiException{
        
        if(mission.getName().isEmpty()||mission.getName()==null){
            throw new MiException("La tarea debe de tener un nombre");
        }
        if(mission.getDetail().isEmpty()||mission.getDetail()==null){
            throw new MiException("La tarea debe de tener un detalle");
        }
        if(mission.getRepeat()==null){
            throw new MiException("La tarea debe de tener un tiempo de repeticion");
        }
         if(mission.getType()==null){
            throw new MiException("La tarea debe ingresar el tipo de tarea");
        }
        
        
    }
    
}
