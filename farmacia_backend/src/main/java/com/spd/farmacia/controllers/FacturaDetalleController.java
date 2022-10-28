/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.controllers;

import com.spd.farmacia.dto.DtoFacturaDetalle;
import com.spd.farmacia.entities.FacturaDetalle;
import com.spd.farmacia.entities.FacturaEncabezado;
import com.spd.farmacia.entities.Medicamento;
import com.spd.farmacia.entities.MetodoPago;
import com.spd.farmacia.services.FacturaDetalleImp;
import com.spd.farmacia.services.FacturaEncabezadoImp;
import com.spd.farmacia.services.MedicamentoImp;
import com.spd.farmacia.services.MetodoPagoImp;
import java.text.ParseException;
import java.util.ArrayList;
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
@RequestMapping("/factura/detalle")
public class FacturaDetalleController {
    @Autowired
    FacturaDetalleImp facturaDetalleImp;
    @Autowired MetodoPagoImp metodoPagoImp;
    @Autowired FacturaEncabezadoImp facturaEncabezadoImp;
    @Autowired MedicamentoImp medicamentoImp;
    
    @GetMapping("/get-one/{id}")
    public ResponseEntity<FacturaDetalle> getOneFacturaDetalle(@PathVariable("id") int idFacturaDetalle) {
        FacturaDetalle FacturaDetalle = facturaDetalleImp.findFacturaDetalle(idFacturaDetalle);
        return new ResponseEntity(FacturaDetalle, HttpStatus.OK);
    }
    

    @GetMapping("/get-all")
    public ResponseEntity<FacturaDetalle> getAllFacturaDetalle() {
        List<FacturaDetalle> lista = facturaDetalleImp.findAllFacturaDetalle();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
    
    @PostMapping("/create-factura")
    public ResponseEntity<?> createFactura(@RequestBody DtoFacturaDetalle dtoFacturaDetalle) throws ParseException {
        FacturaDetalle factura = new FacturaDetalle();
        //Seteo Datos
        MetodoPago metodoPAgo = metodoPagoImp.findMetodoPago(dtoFacturaDetalle.getIdMetodoPago());
        FacturaEncabezado facturaEncabezado = facturaEncabezadoImp.findFacturaEncabezado(dtoFacturaDetalle.getIdFacturaEncabezado());
        
        factura.setFacturaEncabezado(facturaEncabezado);
        factura.setMetodoPago(metodoPAgo);
        factura.setPrecioTotal(dtoFacturaDetalle.getPrecioTotal());
        factura.setFecha(dtoFacturaDetalle.fechaDeString(dtoFacturaDetalle.getFecha()));
        
        List<Medicamento> listaMedicamentos = new ArrayList<>();
        for (Integer idMedicamento : dtoFacturaDetalle.getIdsMedicamentos()) {
            Medicamento medicamento = medicamentoImp.findMedicamento(idMedicamento);
            listaMedicamentos.add(medicamento);
        }
        factura.setMedicamentos(listaMedicamentos);
        
        facturaDetalleImp.saveFacturaDetalle(factura);

        return new ResponseEntity(factura, HttpStatus.OK);

    }
}
