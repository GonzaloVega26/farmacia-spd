/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.controllers;

import com.spd.farmacia.entities.FacturaDetalle;
import com.spd.farmacia.services.DomicilioImp;
import com.spd.farmacia.services.FacturaDetalleImp;
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
@RequestMapping("/factura/detalle")
public class FacturaDetalleController {
    @Autowired
    FacturaDetalleImp FacturaDetalleImp;
    @Autowired
    DomicilioImp domicilioImp;

    @GetMapping("/get-one/{id}")
    public ResponseEntity<FacturaDetalle> getOneFacturaDetalle(@PathVariable("id") int idFacturaDetalle) {
        FacturaDetalle FacturaDetalle = FacturaDetalleImp.findFacturaDetalle(idFacturaDetalle);
        return new ResponseEntity(FacturaDetalle, HttpStatus.OK);
    }
    

    @GetMapping("/get-all")
    public ResponseEntity<FacturaDetalle> getAllFacturaDetalle() {
        List<FacturaDetalle> lista = FacturaDetalleImp.findAllFacturaDetalle();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
}
