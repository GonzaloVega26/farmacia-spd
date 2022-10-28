/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.controllers;

import com.spd.farmacia.dto.DtoFacturaEncabezado;
import com.spd.farmacia.entities.Cliente;
import com.spd.farmacia.entities.Empleado;
import com.spd.farmacia.entities.FacturaEncabezado;
import com.spd.farmacia.entities.RazonSocial;
import com.spd.farmacia.services.ClienteImp;
import com.spd.farmacia.services.EmpleadoImp;
import com.spd.farmacia.services.FacturaEncabezadoImp;
import com.spd.farmacia.services.RazonSocialImp;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author govhe
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/factura/encabezado")
public class FacturaEncabezadoController {
    @Autowired
    FacturaEncabezadoImp facturaEncabezadoImp;
    
    @Autowired ClienteImp clienteImp;
    @Autowired EmpleadoImp empleadoImp;
    @Autowired RazonSocialImp razonSocialImp;
    @GetMapping("/get-one/{id}")
    public ResponseEntity<FacturaEncabezado> getOneFacturaEncabezado(@PathVariable("id") int idFacturaEncabezado) {
        FacturaEncabezado FacturaEncabezado = facturaEncabezadoImp.findFacturaEncabezado(idFacturaEncabezado);
        return new ResponseEntity(FacturaEncabezado, HttpStatus.OK);
    }
    

    @GetMapping("/get-all")
    public ResponseEntity<FacturaEncabezado> getAllFacturaEncabezado() {
        List<FacturaEncabezado> lista = facturaEncabezadoImp.findAllFacturaEncabezado();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @PostMapping("/create-factura")
    public ResponseEntity<?> createFactura(@RequestBody DtoFacturaEncabezado dtoFacturaEncabezado) throws ParseException {
        FacturaEncabezado factura = new FacturaEncabezado();
        //Seteo Datos
        Cliente cliente = clienteImp.findCliente(dtoFacturaEncabezado.getIdCliente());
        Empleado empleado = empleadoImp.findEmpleado(dtoFacturaEncabezado.getIdEmpleado());
        RazonSocial razonSocial = razonSocialImp.findRazonSocial(dtoFacturaEncabezado.getIdRazonSocial());
        
        factura.setCliente(cliente);
        factura.setEmpleado(empleado);
        factura.setRazonSocial(razonSocial);
        
        facturaEncabezadoImp.saveFacturaEncabezado(factura);

        return new ResponseEntity(factura, HttpStatus.OK);

    }
}
