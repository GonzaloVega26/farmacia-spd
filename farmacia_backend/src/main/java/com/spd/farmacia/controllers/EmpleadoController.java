/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.controllers;

import com.spd.farmacia.entities.Empleado;
import com.spd.farmacia.services.EmpleadoImp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author govhe
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoImp empleadoImp;

    @GetMapping("/get-one/{id}")
    public ResponseEntity<Empleado> getOneEmpleado(@PathVariable("id") int idEmpleado) {
        Empleado Empleado = empleadoImp.findEmpleado(idEmpleado);
        return new ResponseEntity(Empleado, HttpStatus.OK);
    }
    
    @GetMapping("/get-one-dni/{dni}")
    public ResponseEntity<Empleado> getOneEmpleadoByDni(@PathVariable("dni") int dniEmpleado) {
        Empleado empleado = empleadoImp.findEmpleadoByDni(dniEmpleado);
        return new ResponseEntity(empleado, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Empleado> getAllEmpleado() {
        List<Empleado> lista = empleadoImp.findAllEmpleado();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
}
