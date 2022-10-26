/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.controllers;

import com.spd.farmacia.entities.Medicamento;
import com.spd.farmacia.services.MedicamentoImp;
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
@RequestMapping("/medicamento")
public class MedicamentoController {
    @Autowired MedicamentoImp medicamentoImp;
    
    @GetMapping("/get-one/{id}")
    public ResponseEntity<Medicamento> getOneMedicamento(@PathVariable("id") int idMedicamento){
        Medicamento medicamento = medicamentoImp.findMedicamento(idMedicamento);
        return new ResponseEntity(medicamento,HttpStatus.OK);
    }
    
    @GetMapping("/get-all")
    public ResponseEntity<Medicamento> getAllMedicamento(){
        List<Medicamento> lista = medicamentoImp.findAllMedicamentos();
        return new ResponseEntity(lista,HttpStatus.OK);
    }
}
