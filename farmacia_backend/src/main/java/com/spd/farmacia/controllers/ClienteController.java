/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.controllers;

import com.spd.farmacia.dto.DtoCliente;
import com.spd.farmacia.entities.Cliente;
import com.spd.farmacia.entities.Domicilio;
import com.spd.farmacia.services.ClienteImp;
import com.spd.farmacia.services.DomicilioImp;
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
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired ClienteImp clienteImp ;
    @Autowired DomicilioImp domicilioImp;
    
    @GetMapping("/get-one/{id}")
    public ResponseEntity<Cliente> getOneCliente(@PathVariable("id") int idCliente){
        Cliente cliente = clienteImp.findCliente(idCliente);
        return new ResponseEntity(cliente,HttpStatus.OK);
    }
    
    @GetMapping("/get-all")
    public ResponseEntity<Cliente> getAllCliente(){
        List<Cliente> lista = clienteImp.findAllCliente();
        return new ResponseEntity(lista,HttpStatus.OK);
    }
    
    
    @PostMapping("/create-cliente")
    public ResponseEntity<?> createCliente(@RequestBody DtoCliente dtoCliente) throws ParseException{
        System.out.println(dtoCliente.toString());
        Cliente cliente = new Cliente();
        cliente.setNombre(dtoCliente.getNombre());
        cliente.setApellido(dtoCliente.getApellido());
        cliente.setDni(dtoCliente.getDni());
        cliente.setFechaNacimiento(dtoCliente.fechaDeString(dtoCliente.getFechaNacimiento()));
        cliente.setMail(dtoCliente.getMail());
        cliente.setTelefono(dtoCliente.getTelefono());
        Domicilio domicilio = domicilioImp.findDomicilio(dtoCliente.getIdDomicilio());
        domicilio.getClientes().add(cliente);
        domicilioImp.saveDomicilio(domicilio);
        System.out.println(domicilio);
        cliente.setDomicilio(domicilio);
        clienteImp.saveCliente(cliente);
        
        return new ResponseEntity(cliente,HttpStatus.OK);
    }
    
}
