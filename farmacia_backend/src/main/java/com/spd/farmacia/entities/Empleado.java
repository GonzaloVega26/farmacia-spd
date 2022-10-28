/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.entities;

import com.spd.farmacia.entities.enums.TurnoEnum;
import com.sun.istack.NotNull;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author govhe
 */
@Getter
@Setter
@Entity
public class Empleado {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    @Column(unique=true)
    private long dni;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @NotNull
    private String mail;
    
    private long telefono;
    private double salario;
    
    @Enumerated(EnumType.STRING)
    private TurnoEnum turno;
    
    @ManyToOne
    @JoinColumn(name = "idDomicilio")
    private Domicilio domicilio;
    
    @ManyToOne
    @JoinColumn(name = "idGenero")
    private Genero genero;
}
