/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author govhe
 */
@Getter
@Setter
@Entity
public class FacturaEncabezado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "idRazonSocial")
    private RazonSocial razonSocial;
    
    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;
    
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
}
