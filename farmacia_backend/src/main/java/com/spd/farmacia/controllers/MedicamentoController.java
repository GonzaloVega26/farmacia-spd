/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.controllers;

import com.spd.farmacia.dto.DtoMedicamento;
import com.spd.farmacia.entities.Laboratorio;
import com.spd.farmacia.entities.Medicamento;
import com.spd.farmacia.services.LaboratorioImp;
import com.spd.farmacia.services.MedicamentoImp;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/medicamento")
public class MedicamentoController {
    @Autowired MedicamentoImp medicamentoImp;
    @Autowired LaboratorioImp laboratorioImp;
    
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
    
    @GetMapping("/get-medicamento/{nombre}")
    public ResponseEntity<Medicamento> getMedicamentoByNombre(@PathVariable("nombre") String nombre){
        List<Medicamento> lista = medicamentoImp.getMedicamentoByNombre(nombre);
            return new ResponseEntity(lista,HttpStatus.OK);
       
    }
    
    
    @PostMapping("/create-medicamento")
    public ResponseEntity<?> createMedicamento(@RequestBody DtoMedicamento dtoMedicamento) throws ParseException {
        //Creacion de Medicamento
        Medicamento medicamento = new Medicamento();
        medicamento.setNombre(dtoMedicamento.getNombre());
        medicamento.setLote(dtoMedicamento.getLote());
        medicamento.setEsRecetado(dtoMedicamento.isEsRecetado());
        medicamento.setFechaVenc(dtoMedicamento.fechaDeString(dtoMedicamento.getFechaVencimiento()));
        medicamento.setStock(dtoMedicamento.getStock());
        medicamento.setPrecioUnitario(dtoMedicamento.getPrecioUnitario());
        
        Laboratorio laboratorio  = laboratorioImp.findLaboratorio(dtoMedicamento.getIdLaboratorio());
        
        medicamento.setLaboratorio(laboratorio);
        //Se actualiza laboratorio
        laboratorio.getMedicamentos().add(medicamento);
        laboratorioImp.saveLaboratorio(laboratorio);
        
        medicamentoImp.saveMedicamento(medicamento);
        
        return new ResponseEntity(medicamento, HttpStatus.OK);

    }
}
