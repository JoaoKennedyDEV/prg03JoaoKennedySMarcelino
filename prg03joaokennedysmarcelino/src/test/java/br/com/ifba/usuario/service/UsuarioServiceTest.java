/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.service;

import br.com.ifba.infrastructure.exception.NegocioException;
import br.com.ifba.usuario.dao.FakePessoaDao;
import br.com.ifba.usuario.dao.FakeUsuarioDao;
import br.com.ifba.usuario.entity.Pessoa;
import br.com.ifba.usuario.entity.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author kennedy
 */
public class UsuarioServiceTest {

    private FakePessoaDao pessoaDao;
    private UsuarioIService service;

    @BeforeEach
    void setUp() {
        pessoaDao = new FakePessoaDao();
        service = new UsuarioService(new FakeUsuarioDao(), pessoaDao);
    }

    // monta um usuário que passa em todas as regras
    private Usuario novoUsuario(String nome, String cpf, String login, String senha) {
        Pessoa p = new Pessoa(nome, cpf);
        p.setDataNascimento("01012000");
        p.setTelefone("75999999999");
        return new Usuario(p, login, senha);
    }

    private Usuario valido() {
        return novoUsuario("Joao Kennedy", "12345678901", "joao123", "senha1234");
    }

    @Test
    void deveSalvarUsuarioValido() {
        Usuario salvo = service.save(valido());
        assertNotNull(salvo.getId());
    }

    @Test
    void naoDeveAceitarNomeCurto() {
        Usuario u = novoUsuario("Ana", "12345678901", "joao123", "senha1234");
        assertThrows(NegocioException.class, () -> service.save(u));
    }

    @Test
    void naoDeveAceitarCpfIncompleto() {
        Usuario u = novoUsuario("Joao Kennedy", "123", "joao123", "senha1234");
        assertThrows(NegocioException.class, () -> service.save(u));
    }

    @Test
    void naoDeveAceitarLoginCurto() {
        Usuario u = novoUsuario("Joao Kennedy", "12345678901", "abc", "senha1234");
        assertThrows(NegocioException.class, () -> service.save(u));
    }

    @Test
    void naoDeveAceitarSenhaCurta() {
        Usuario u = novoUsuario("Joao Kennedy", "12345678901", "joao123", "123");
        assertThrows(NegocioException.class, () -> service.save(u));
    }

    @Test
    void naoDeveAceitarLoginProibido() {
        Usuario u = novoUsuario("Joao Kennedy", "12345678901", "admin", "senha1234");
        assertThrows(NegocioException.class, () -> service.save(u));
    }

    @Test
    void naoDeveAceitarLoginRepetido() {
        service.save(valido());
        Usuario outro = novoUsuario("Maria Souza", "98765432100", "joao123", "senha1234");
        assertThrows(NegocioException.class, () -> service.save(outro));
    }

    @Test
    void naoDeveAceitarCpfRepetido() {
        Usuario primeiro = valido();
        service.save(primeiro);
        pessoaDao.save(primeiro.getPessoa());   // simula o cascade que o banco faria

        Usuario outro = novoUsuario("Maria Souza", "12345678901", "maria123", "senha1234");
        assertThrows(NegocioException.class, () -> service.save(outro));
    }
}
