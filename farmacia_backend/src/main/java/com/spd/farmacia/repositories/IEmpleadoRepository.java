/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spd.farmacia.repositories;

import com.spd.farmacia.entities.Empleado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author govhe
 */
@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado,Integer> {
    public Empleado findByDni(long dni); 
    
     @Query(value = "SELECT * FROM empleado WHERE id_domicilio=?;",nativeQuery = true)
     public List<Empleado> listEmpleadosQuery(int id);
}
