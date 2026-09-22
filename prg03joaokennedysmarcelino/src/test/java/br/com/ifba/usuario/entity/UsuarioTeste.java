/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author kennedy
 */
public class UsuarioTeste {
    
    @Test
    public void DeveautenticarQuandoDadosIncorreto(){
        Usuario usuario = new Usuario();
        usuario.setLogin("testLogin");
        usuario.setSenha("testSenha");
        
        boolean resultado = usuario.autenticar("testLogin","testSenha");
        
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveautenticarQuandoDadosIncorreto(){
        Usuario usuario = new Usuario();
        usuario.setLogin("testLogin");
        usuario.setSenha("testSenha");
        
        boolean resultado = usuario.autenticar("testLogin","SenhaErrada");
        
        assertFalse(resultado);
    }

}
