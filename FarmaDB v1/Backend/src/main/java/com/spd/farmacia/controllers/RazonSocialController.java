/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.controllers;

import com.spd.farmacia.entities.RazonSocial;
import com.spd.farmacia.services.RazonSocialImp;
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
@RequestMapping("/razon-social")
public class RazonSocialController {
    @Autowired
    RazonSocialImp razonSocialImp;
    
    @GetMapping("/get-one/{id}")
    public ResponseEntity<RazonSocial> getOneRazonSocial(@PathVariable("id") int idRazonSocial) {
        RazonSocial RazonSocial = razonSocialImp.findRazonSocial(idRazonSocial);
        return new ResponseEntity(RazonSocial, HttpStatus.OK);
    }
    

    @GetMapping("/get-all")
    public ResponseEntity<RazonSocial> getAllRazonSocial() {
        List<RazonSocial> lista = razonSocialImp.findAllRazonSocial();
        return new ResponseEntity(lista, HttpStatus.OK);
    }
}
