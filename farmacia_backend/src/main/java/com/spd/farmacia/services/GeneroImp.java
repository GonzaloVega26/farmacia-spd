/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.services;

import com.spd.farmacia.entities.Genero;
import com.spd.farmacia.repositories.IGeneroRepository;
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
public class GeneroImp {
      @Autowired IGeneroRepository iGeneroRepository;
    
    public Genero findGenero(int id) {
        Genero Genero = iGeneroRepository.findById(id).orElse(null);
        return Genero;
    }
    
    public List<Genero> findAllGenero() {
        List<Genero> lista = iGeneroRepository.findAll();
        return lista;
    }
    public void saveGenero(Genero Genero){
        iGeneroRepository.save(Genero);
    }
    
    public void deleteGenero(int idGenero){
        iGeneroRepository.deleteById(idGenero);
    }
}
