/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

import br.com.ifba.usuario.entity.Pessoa;
import br.com.ifba.usuario.entity.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;

/**
 *
 * @author kennedy
 */
public class RepositorioUsuarioEmMemoriaTest {
    
    @Test
    public void cadastraUmUsuarioEEleApareceEmListarTodos() {
        RepositorioUsuarioEmMemoria repo = new RepositorioUsuarioEmMemoria();
        Usuario u = novoUsuario("kennedy01");
        repo.cadastrar(u);
        assertTrue(repo.listarTodos().size() == 1);
        assertTrue(repo.listarTodos().contains(u));
    }

    private Usuario novoUsuario(String login) {
        return new Usuario(new Pessoa("Kennedy Santos", "12345678900"), login, "senha123");
    }

    @Test
    public void cadastraDoisEBuscarPorLoginDevolveOCerto() {
        RepositorioUsuarioEmMemoria repo = new RepositorioUsuarioEmMemoria();
        Usuario primeiro = novoUsuario("ana");
        Usuario segundo = novoUsuario("bruno");
        repo.cadastrar(primeiro);
        repo.cadastrar(segundo);

        assertTrue(repo.buscarPorLogin("bruno") == segundo);
        assertTrue(repo.buscarPorLoginComLista("ana") == primeiro);
    }

    @Test
    public void buscarPorLoginInexistenteDeveLancarExcecao() {
        RepositorioUsuarioEmMemoria repo = new RepositorioUsuarioEmMemoria();
        repo.cadastrar(novoUsuario("ana"));

        assertThrows(UsuarioNaoEncontradoException.class, () -> repo.buscarPorLogin("naoexiste"));
        assertThrows(UsuarioNaoEncontradoException.class, () -> repo.buscarPorLoginComLista("naoexiste"));
    }

    @Test
    public void buscarPorLoginExistenteNaoDeveLancarExcecao() {
        RepositorioUsuarioEmMemoria repo = new RepositorioUsuarioEmMemoria();
        repo.cadastrar(novoUsuario("ana"));

        assertDoesNotThrow(() -> repo.buscarPorLogin("ana"));
        assertDoesNotThrow(() -> repo.buscarPorLoginComLista("ana"));
    }

    @Test
    public void mensagemDaExcecaoDeveConterOLogin() {
        RepositorioUsuarioEmMemoria repo = new RepositorioUsuarioEmMemoria();

        UsuarioNaoEncontradoException e = assertThrows(
                UsuarioNaoEncontradoException.class,
                () -> repo.buscarPorLogin("fulano"));

        assertTrue(e.getMessage().contains("fulano"));
    }

    @Test
    public void objetosDiferentesComMesmoLoginSaoIguaisParaALista() {
        RepositorioUsuarioEmMemoria repo = new RepositorioUsuarioEmMemoria();
        Usuario um = novoUsuario("kennedy01");
        Usuario outro = novoUsuario("kennedy01");
        repo.cadastrar(um);

        assertTrue(um != outro);
        assertTrue(repo.listarTodos().contains(outro));
    }
    
}
