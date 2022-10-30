/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.entities;

import com.sun.istack.NotNull;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class FacturaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private double precioTotal;
    private Date fecha;
   
    @ManyToMany
    @JoinTable(name = "factdetalle_has_medicamentos",
           joinColumns = { @JoinColumn(name = "idFactdetalle")  },
           inverseJoinColumns = { @JoinColumn(name = "idMedicamento") })
    private List<Medicamento> medicamentos;
    
    @ManyToOne
    @JoinColumn(name = "idMetodoPago")
    private MetodoPago metodoPago;
    
    @ManyToOne
    @JoinColumn(name = "idFacturaEncabezado")
    private FacturaEncabezado facturaEncabezado;


}
