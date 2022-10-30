/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author govhe
 */
@Getter
@Setter
public class DtoDomicilio {
    private String provincia;
    private String departamento;
    private int cp;
    private String calle;
    private int numero;
    private String observaciones;
}
