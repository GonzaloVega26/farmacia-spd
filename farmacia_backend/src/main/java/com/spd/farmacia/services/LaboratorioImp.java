/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.services;

import com.spd.farmacia.entities.Laboratorio;
import com.spd.farmacia.repositories.ILaboratorioRepository;
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
public class LaboratorioImp {
    @Autowired ILaboratorioRepository  iLaboratorioRepository;
   
    public Laboratorio findLaboratorio(int id) {
        Laboratorio laboratorio = iLaboratorioRepository.findById(id).orElse(null);
        return laboratorio;
    }
    
    public List<Laboratorio> findAllLaboratorio() {
        List<Laboratorio> lista = iLaboratorioRepository.findAll();
        return lista;
    }
    
     public void saveLaboratorio(Laboratorio laboratorio){
        iLaboratorioRepository.save(laboratorio);
    }
    
    public void deleteLaboratorio(int idLaboratorio){
        iLaboratorioRepository.deleteById(idLaboratorio);
    }
}
