/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.services;

import com.spd.farmacia.entities.Empleado;
import com.spd.farmacia.repositories.IEmpleadoRepository;
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
public class EmpleadoImp {
    @Autowired IEmpleadoRepository  iEmpleadoRepository;
   
    public Empleado findEmpleado(int id) {
        Empleado Empleado = iEmpleadoRepository.findById(id).orElse(null);
        return Empleado;
    }
    
    public List<Empleado> findAllEmpleado() {
        List<Empleado> lista = iEmpleadoRepository.findAll();
        return lista;
    }
    
     public void saveEmpleado(Empleado empleado){
        iEmpleadoRepository.save(empleado);
    }
    
    public void deleteEmpleado(int idEmpleado){
        iEmpleadoRepository.deleteById(idEmpleado);
    }
    
    public Empleado findEmpleadoByDni(long dni){
        return iEmpleadoRepository.findByDni(dni);
    }
}
