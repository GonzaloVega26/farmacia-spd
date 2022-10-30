/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.services;

import com.spd.farmacia.entities.MetodoPago;
import com.spd.farmacia.repositories.IMetodoPagoRepository;
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
public class MetodoPagoImp {
     @Autowired IMetodoPagoRepository  iMetodoPagoRepository;
   
    public MetodoPago findMetodoPago(int id) {
        MetodoPago MetodoPago = iMetodoPagoRepository.findById(id).orElse(null);
        return MetodoPago;
    }
    
    public List<MetodoPago> findAllMetodoPago() {
        List<MetodoPago> lista = iMetodoPagoRepository.findAll();
        return lista;
    }
    
     public void saveMetodoPago(MetodoPago metodoPago){
        iMetodoPagoRepository.save(metodoPago);
    }
    
    public void deleteMetodoPago(int idMetodoPago){
        iMetodoPagoRepository.deleteById(idMetodoPago);
    }
}
