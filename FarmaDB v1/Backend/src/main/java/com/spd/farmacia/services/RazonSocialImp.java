/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.services;

import com.spd.farmacia.entities.RazonSocial;
import com.spd.farmacia.repositories.IRazonSocialRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author govhe
 */
@Service
@Transactional
public class RazonSocialImp {
     @Autowired IRazonSocialRepository  iRazonSocialRepository;
   
    public RazonSocial findRazonSocial(int id) {
        RazonSocial RazonSocial = iRazonSocialRepository.findById(id).orElse(null);
        return RazonSocial;
    }
    
    public List<RazonSocial> findAllRazonSocial() {
        List<RazonSocial> lista = iRazonSocialRepository.findAll();
        return lista;
    }
    
     public void saveRazonSocial(RazonSocial razonSocial){
        iRazonSocialRepository.save(razonSocial);
    }
    
    public void deleteRazonSocial(int idRazonSocial){
        iRazonSocialRepository.deleteById(idRazonSocial);
    }
}
