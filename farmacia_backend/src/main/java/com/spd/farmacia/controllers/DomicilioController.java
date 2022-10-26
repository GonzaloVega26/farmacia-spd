/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.controllers;

import com.spd.farmacia.dto.DtoDomicilio;
import com.spd.farmacia.entities.Cliente;
import com.spd.farmacia.entities.Domicilio;
import com.spd.farmacia.services.DomicilioImp;
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
@RequestMapping("/domicilio")
public class DomicilioController {
    @Autowired DomicilioImp domicilioImp ;
    
    @GetMapping("/get-one/{id}")
    public ResponseEntity<Domicilio> getOneDomicilio(@PathVariable("id") int idDomicilio){
        Domicilio domicilio = domicilioImp.findDomicilio(idDomicilio);
        return new ResponseEntity(domicilio,HttpStatus.OK);
    }
    
    @GetMapping("/get-all")
    public ResponseEntity<Domicilio> getAllDomicilio(){
        List<Domicilio> lista = domicilioImp.findAllDomicilio();
        return new ResponseEntity(lista,HttpStatus.OK);
    }
    
    @PostMapping("/create-domicilio")
    public ResponseEntity<?> createDomicilio(@RequestBody DtoDomicilio dtoDomicilio){

        Domicilio domicilio=  new Domicilio();
        domicilio.setProvincia(dtoDomicilio.getProvincia());
        domicilio.setDepartamento(dtoDomicilio.getDepartamento());
        domicilio.setCp(dtoDomicilio.getCp());
        domicilio.setCalle(dtoDomicilio.getCalle());
        domicilio.setNumero(dtoDomicilio.getNumero());
        domicilio.setObservaciones(dtoDomicilio.getObservaciones());
        
        //Se crea el domicilio primero con una lista vacia de clientes
        domicilio.setClientes(new ArrayList<Cliente>());
        domicilioImp.saveDomicilio(domicilio);
        
        return new ResponseEntity(domicilio,HttpStatus.OK);
    }
}
