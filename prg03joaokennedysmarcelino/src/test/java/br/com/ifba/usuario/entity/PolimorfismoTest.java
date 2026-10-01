/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.usuario.interfaces.Autenticavel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kennedy
 */
public class PolimorfismoTest {

    @Test
    public void usuarioComumAutenticaPeloProprioCanal() {
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        Autenticavel pessoaAutenticavel = new UsuarioBasico(pessoa, "kennedy01", "senha1234");

        String resultado = pessoaAutenticavel.autenticar("kennedy01", "senha1234");

        assertTrue(resultado.equals("Bem-vindo, kennedy01"));
    }

    @Test
    public void administradorAutenticaDeFormaDiferente() {
        Pessoa pessoa = new Pessoa("Ana Souza", "98765432100");
        Autenticavel pessoaAutenticavel = new UsuarioAdmin(pessoa, "ana.admin", "senhaForte1");

        String resultado = pessoaAutenticavel.autenticar("ana.admin", "senhaForte1");

        assertTrue(resultado.equals("Acesso administrativo liberado: ana.admin"));
    }

    @Test
    public void mesmaChamadaDevolveMensagensDiferentesPorClasse() {
        Pessoa p1 = new Pessoa("Kennedy Santos", "12345678900");
        Pessoa p2 = new Pessoa("Ana Souza", "98765432100");

        Autenticavel comum = new UsuarioBasico(p1, "kennedy01", "senha1234");
        Autenticavel admin = new UsuarioAdmin(p2, "ana.admin", "senhaForte1");

        String saidaComum = br.com.ifba.usuario.util.ProcessoDeAcesso.processar(comum, "kennedy01", "senha1234");
        String saidaAdmin = br.com.ifba.usuario.util.ProcessoDeAcesso.processar(admin, "ana.admin", "senhaForte1");

        assertFalse(saidaComum.equals(saidaAdmin));
    }

    @Test
    public void credenciaisErradasDevolveAcessoNegadoParaQualquerTipo() {
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        Autenticavel pessoaAutenticavel = new UsuarioBasico(pessoa, "kennedy01", "senha1234");

        String resultado = pessoaAutenticavel.autenticar("kennedy01", "senhaErrada");

        assertTrue(resultado.equals("Acesso negado"));
    }
}
