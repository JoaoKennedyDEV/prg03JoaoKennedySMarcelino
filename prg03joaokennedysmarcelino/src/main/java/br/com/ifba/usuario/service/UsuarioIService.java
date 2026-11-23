/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.service;


import br.com.ifba.usuario.entity.Usuario;
import java.util.List;
/**
 *
 * @author kennedy
 */
public interface UsuarioIService {
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(Usuario usuario);
    Usuario findById(Long id);
    List<Usuario> findAll();
    Usuario findByLogin(String login);
    List<Usuario> findByNome(String nome);
}
