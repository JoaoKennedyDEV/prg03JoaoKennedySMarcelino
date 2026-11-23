/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.service.UsuarioIService;
import java.util.List;
/**
 *
 * @author kennedy
 */

public class UsuarioController implements UsuarioIController {

    private final UsuarioIService service;

    public UsuarioController(UsuarioIService service) {
        this.service = service;
    }

    @Override
    public Usuario save(Usuario usuario) { 
        return service.save(usuario); 
    }

    @Override
    public Usuario update(Usuario usuario) { 
        return service.update(usuario); 
    }

    @Override
    public void delete(Usuario usuario) {
        service.delete(usuario); 
    }

    @Override
    public Usuario findById(Long id) { 
        return service.findById(id); 
    }

    @Override
    public List<Usuario> findAll() { 
        return service.findAll(); 
    }

    @Override
    public Usuario findByLogin(String login) { 
        return service.findByLogin(login); 
    }

    @Override
    public List<Usuario> findByNome(String nome) { 
        return service.findByNome(nome); 
    }
}
