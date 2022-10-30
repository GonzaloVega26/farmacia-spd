/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.repositories;

import com.spd.farmacia.entities.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author govhe
 */
@Repository
public interface ILaboratorioRepository  extends JpaRepository<Laboratorio, Integer> {
    
}
