/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.services;

import com.spd.farmacia.entities.FacturaEncabezado;
import com.spd.farmacia.repositories.IFacturaEncabezadoRepository;
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
public class FacturaEncabezadoImp {
    @Autowired IFacturaEncabezadoRepository  iFacturaEncabezadoRepository;
   
    public FacturaEncabezado findFacturaEncabezado(int id) {
        FacturaEncabezado FacturaEncabezado = iFacturaEncabezadoRepository.findById(id).orElse(null);
        return FacturaEncabezado;
    }
    
    public List<FacturaEncabezado> findAllFacturaEncabezado() {
        List<FacturaEncabezado> lista = iFacturaEncabezadoRepository.findAll();
        return lista;
    }
    
     public void saveFacturaEncabezado(FacturaEncabezado facturaEncabezado){
        iFacturaEncabezadoRepository.save(facturaEncabezado);
    }
    
    public void deleteFacturaEncabezado(int idFacturaEncabezado){
        iFacturaEncabezadoRepository.deleteById(idFacturaEncabezado);
    }
}
