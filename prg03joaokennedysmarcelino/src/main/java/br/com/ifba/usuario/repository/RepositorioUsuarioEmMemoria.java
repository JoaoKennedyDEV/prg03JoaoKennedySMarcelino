/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kennedy
 */
public class RepositorioUsuarioEmMemoria {
    private final List<Usuario> usuarios = new ArrayList<>();
    private final Map<String, Usuario> porLogin = new HashMap<>();
    
    public void cadastrar(Usuario usuario){
        usuarios.add(usuario);
        porLogin.put(usuario.getLogin(), usuario);
    }
    public List<Usuario> listarTodos(){
        return new ArrayList<>(usuarios);
    }
    
    public Usuario buscarPorLoginComLista(String login) {
        for (Usuario user : usuarios) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
    
    public Usuario buscarPorLogin(String login){
       return porLogin.get(login); 
    }
}
