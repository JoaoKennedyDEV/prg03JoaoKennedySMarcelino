/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import org.junit.jupiter.api.Test;
import br.com.ifba.usuario.entity.Status;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author kennedy
 */
public class UsuarioRelacionamentoTeste {
@Test
    public void deveDevolverAPessoaRelacionada() {
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        Usuario usuario = new Usuario(pessoa, "kennedy01", "senha1234");

        assertTrue(usuario.getPessoa() == pessoa);
    }

    @Test
    public void deveNascerComStatusInativo() {
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        Usuario usuario = new Usuario(pessoa, "kennedy01", "senha1234");

        assertTrue(usuario.getStatus() == Status.INATIVO);
    }

    @Test
    public void deveNascerSemPerfis() {
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        Usuario usuario = new Usuario(pessoa, "kennedy01", "senha1234");

        assertTrue(usuario.getPerfis().isEmpty());
    }

    @Test
    public void deveCrescerListaAoAdicionarPerfil() {
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        Usuario usuario = new Usuario(pessoa, "kennedy01", "senha1234");

        usuario.adicionarPerfil(new Perfil("ADMIN", "Administrador"));
        usuario.adicionarPerfil(new Perfil("ATENDENTE", "Atendimento"));

        assertTrue(usuario.getPerfis().size() == 2);
    }

    @Test
    public void primeiroPerfilDeveVirarPerfilAtivo() {
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        Usuario usuario = new Usuario(pessoa, "kennedy01", "senha1234");
        Perfil admin = new Perfil("ADMIN", "Administrador");

        usuario.adicionarPerfil(admin);

        assertTrue(usuario.getPerfilAtivo() == admin);
    }

    @Test
    public void deveAlterarStatusParaAtivo() {
        Pessoa pessoa = new Pessoa("Kennedy Santos", "12345678900");
        Usuario usuario = new Usuario(pessoa, "kennedy01", "senha1234");

        usuario.setStatus(Status.ATIVO);

        assertTrue(usuario.getStatus() == Status.ATIVO);
    }

}