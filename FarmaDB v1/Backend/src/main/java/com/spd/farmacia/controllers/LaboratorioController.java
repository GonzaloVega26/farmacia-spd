/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.controllers;

import com.spd.farmacia.dto.DtoDomicilio;
import com.spd.farmacia.dto.DtoLaboratorio;
import com.spd.farmacia.entities.Domicilio;
import com.spd.farmacia.entities.Laboratorio;
import com.spd.farmacia.entities.Medicamento;
import com.spd.farmacia.services.LaboratorioImp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author govhe
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/laboratorio")
public class LaboratorioController {

    @Autowired
    LaboratorioImp laboratorioImp;

    @GetMapping("/get-one/{id}")
    public ResponseEntity<Laboratorio> getOneLaboratorio(@PathVariable("id") int idLaboratorio) {
        Laboratorio laboratorio = laboratorioImp.findLaboratorio(idLaboratorio);
        return new ResponseEntity(laboratorio, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Laboratorio> getAllLaboratorio() {
        List<Laboratorio> lista = laboratorioImp.findAllLaboratorio();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @PostMapping("/create-laboratorio")
    public ResponseEntity<?> createLaboratorio(@RequestBody DtoLaboratorio dtoLaboratorio) {

        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setNombre(dtoLaboratorio.getNombre());
        laboratorio.setMedicamentos(new ArrayList<Medicamento>());
        laboratorioImp.saveLaboratorio(laboratorio);

        return new ResponseEntity(laboratorio, HttpStatus.OK);
    }

    @DeleteMapping("/delete-laboratorio/{id}")
    public ResponseEntity<?> deleteLaboratorio(@PathVariable("id") int id) {

        laboratorioImp.deleteLaboratorio(id);
        return new ResponseEntity("Laboratorio Eliminado", HttpStatus.OK);
    }

    @PutMapping("/update-laboratorio/{id}")
    public ResponseEntity<?> updateLaboratorio(@PathVariable("id") int id, @RequestBody DtoLaboratorio dtoLaboratorio) {

        Laboratorio laboratorio = laboratorioImp.findLaboratorio(id);
        laboratorio.setNombre(dtoLaboratorio.getNombre());
        laboratorioImp.saveLaboratorio(laboratorio);
        return new ResponseEntity(laboratorio, HttpStatus.OK);
    }
}
