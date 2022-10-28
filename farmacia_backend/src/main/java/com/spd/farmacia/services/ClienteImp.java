/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spd.farmacia.services;

import com.spd.farmacia.entities.Cliente;
import com.spd.farmacia.repositories.IClienteRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author govhe
 */
@Service
@Transactional
public class ClienteImp {
    @Autowired IClienteRepository iClienteRepository;
    
    public Cliente findCliente(int id) {
        Cliente cliente = iClienteRepository.findById(id).orElse(null);
        return cliente;
    }
    
    public List<Cliente> findAllCliente() {
        List<Cliente> lista = iClienteRepository.findAll();
        return lista;
    }
    
    public void saveCliente(Cliente cliente){
       iClienteRepository.save(cliente);
    }
    
    public void deleteCliente(int idCliente){
        iClienteRepository.deleteById(idCliente);
    }
    
    public Cliente findClienteByDni(long dni){
        return iClienteRepository.findByDni(dni);
    }
}
