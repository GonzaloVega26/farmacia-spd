/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.services;

import com.spd.farmacia.entities.Domicilio;
import com.spd.farmacia.repositories.IDomicilioRepository;
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
public class DomicilioImp {
      @Autowired IDomicilioRepository iDomicilioRepository;
    
    public Domicilio findDomicilio(int id) {
        Domicilio domicilio = iDomicilioRepository.findById(id).orElse(null);
        return domicilio;
    }
    
    public List<Domicilio> findAllDomicilio() {
        List<Domicilio> lista = iDomicilioRepository.findAll();
        return lista;
    }
    public void saveDomicilio(Domicilio domicilio){
        iDomicilioRepository.save(domicilio);
    }
    
    public void deleteDomicilio(int idDomicilio){
        iDomicilioRepository.deleteById(idDomicilio);
    }
}
