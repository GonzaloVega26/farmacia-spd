/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spd.farmacia.repositories;

import com.spd.farmacia.entities.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author govhe
 */
@Repository
public interface IMetodoPagoRepository extends JpaRepository<MetodoPago,Integer>{
    
}
