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
public class DtoCliente {
    private String nombre;
    private String apellido;
    private long dni;
    private String fechaNacimiento;
    private String mail;
    
    private long telefono;
    
    private int idDomicilio;
    
    public Date fechaDeString(String fecha) throws ParseException{
        Date date= new SimpleDateFormat("dd/MM/yyyy").parse(fecha);  
        return date;
    }

    @Override
    public String toString() {
        return "DtoCliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", mail=" + mail + ", telefono=" + telefono + ", idDomicilio=" + idDomicilio + '}';
    }
    
}
