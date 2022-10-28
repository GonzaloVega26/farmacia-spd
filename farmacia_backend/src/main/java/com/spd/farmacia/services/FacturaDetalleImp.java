/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.services;

import com.spd.farmacia.entities.FacturaDetalle;
import com.spd.farmacia.repositories.IFacturaDetalleRepository;
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
public class FacturaDetalleImp {
     @Autowired IFacturaDetalleRepository  iFacturaDetalleRepository;
   
    public FacturaDetalle findFacturaDetalle(int id) {
        FacturaDetalle FacturaDetalle = iFacturaDetalleRepository.findById(id).orElse(null);
        return FacturaDetalle;
    }
    
    public List<FacturaDetalle> findAllFacturaDetalle() {
        List<FacturaDetalle> lista = iFacturaDetalleRepository.findAll();
        return lista;
    }
    
     public void saveFacturaDetalle(FacturaDetalle facturaDetalle){
        iFacturaDetalleRepository.save(facturaDetalle);
    }
    
    public void deleteFacturaDetalle(int idFacturaDetalle){
        iFacturaDetalleRepository.deleteById(idFacturaDetalle);
    }
}
