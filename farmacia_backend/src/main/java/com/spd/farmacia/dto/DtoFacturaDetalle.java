/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author govhe
 */
@Getter
@Setter
public class DtoFacturaDetalle {
    
    private double precioTotal;
    private List<Integer> medicamentos;
    private Integer idMetodoPago;
    private String fecha;
    public Date fechaDeString(String fecha) throws ParseException{
        Date date= new SimpleDateFormat("dd/MM/yyyy").parse(fecha);  
        return date;
    }

}
