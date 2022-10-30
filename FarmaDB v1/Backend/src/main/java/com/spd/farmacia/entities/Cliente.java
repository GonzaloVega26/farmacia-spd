/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.entities;

import com.sun.istack.NotNull;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
public class Cliente {
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
    
    @ManyToOne
    @JoinColumn(name = "idDomicilio")
    private Domicilio domicilio;
    
    
    @ManyToOne
    @JoinColumn(name = "idGenero")
    private Genero genero;
    
    @ManyToMany
    private List<ObraSocial> obrasSociales;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, long dni, Date fechaNacimiento, String mail, long telefono, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.mail = mail;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", mail=" + mail + ", telefono=" + telefono + ", domicilio=" + domicilio + '}';
    }
    
    
}
