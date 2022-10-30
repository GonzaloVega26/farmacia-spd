/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author govhe
 */
@Getter
@Setter
public class DtoMedicamento {
    private String nombre;
    private int lote;
    private String fechaVencimiento;
    private boolean esRecetado;
    private int stock;
    private double precioUnitario;
    private int idLaboratorio;
    
     public Date fechaDeString(String fecha) throws ParseException{
        Date date= new SimpleDateFormat("yyyy-MM-dd").parse(fecha);  
        return date;
    }
}
