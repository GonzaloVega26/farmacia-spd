/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.services;

import com.spd.farmacia.entities.Medicamento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spd.farmacia.repositories.IMedicamentoRepository;
import java.util.Optional;
import javax.transaction.Transactional;

/**
 *
 * @author govhe
 */
@Service
@Transactional
public class MedicamentoImp {
    @Autowired IMedicamentoRepository  iMedicamentoRepository;
   
    public Medicamento findMedicamento(int id) {
        Medicamento medicamento = iMedicamentoRepository.findById(id).orElse(null);
        return medicamento;
    }
    
    public List<Medicamento> findAllMedicamentos() {
        List<Medicamento> lista = iMedicamentoRepository.findAll();
        return lista;
    }
    
    
     public void saveMedicamento(Medicamento medicamento){
        iMedicamentoRepository.save(medicamento);
    }
    
    public void deleteMedicamento(int idMedicamento){
        iMedicamentoRepository.deleteById(idMedicamento);
    }
       
    public List<Medicamento> getMedicamentoByNombre(String nombre){
        return iMedicamentoRepository.findByNombreContaining(nombre);
    }
}
