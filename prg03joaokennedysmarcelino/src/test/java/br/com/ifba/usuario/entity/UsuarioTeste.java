/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author kennedy
 */
public class UsuarioTeste {
    
    @Test
    public void DeveautenticarQuandoDadosCorreto(){
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        Usuario usuario = new Usuario(pessoa, "testLogin", "testSenha");
        
        boolean resultado = usuario.autenticar("testLogin","testSenha");
        
        assertTrue(resultado);
    }
    
    @Test
    public void naoDeveautenticarQuandoDadosIncorreto(){
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        Usuario usuario = new Usuario(pessoa, "testLogin", "testSenha");
        
        boolean resultado = usuario.autenticar("testLogin","SenhaErrada");
        
        assertFalse(resultado);
    }
    
    @Test
    public void usuarioBasicoDeveDevolverSeuNivelDeAcesso() {
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        UsuarioBasico usuario = new UsuarioBasico(pessoa, "kennedy01", "senhatest");

        assertTrue(usuario.getNivelAcesso().equals("BASICO"));
    }
    
     @Test
    public void usuarioAdminDeveDevolverSeuNivelDeAcesso() {
        Pessoa pessoa = new Pessoa("Kennedy santos", "98765432100");
        UsuarioAdmin usuario = new UsuarioAdmin(pessoa, "kennedyadmin", "senhatest");

        assertTrue(usuario.getNivelAcesso().equals("ADMIN"));
    }
    
    public void usuarioAdminDeveSerReconhecidoComoUsuario()  {
        Pessoa pessoa = new Pessoa("Kennedy santos", "98765432100");
        UsuarioAdmin usuario = new UsuarioAdmin(pessoa, "kennedyadmin", "senhatest");

        assertTrue(usuario instanceof Usuario);
    }
    
}
