/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.exception.ErroDePersistenciaException;
import br.com.ifba.usuario.entity.Pessoa;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author kennedy
 */

public class UsuarioDaoTest {

    private final UsuarioIDao dao = new UsuarioDao();

    @Test
    void saveNuloLancaErroDePersistencia() {
        assertThrows(ErroDePersistenciaException.class, () -> dao.save(null));
    }

    @Test
    void findByLoginInexistenteLancaNaoEncontrado() {
        assertThrows(UsuarioNaoEncontradoException.class,
                () -> dao.findByLogin("login_que_nao_existe_xyz"));
    }

    @Test
    void loginDuplicadoLancaErroDePersistencia() {
        Usuario a = new Usuario(new Pessoa("Teste Um", "999.999.999-01"), "duplicado_t1", "senha1234");
        Usuario b = new Usuario(new Pessoa("Teste Dois", "999.999.999-02"), "duplicado_t1", "senha1234");
        dao.save(a);
        try {
            assertThrows(ErroDePersistenciaException.class, () -> dao.save(b));
        } finally {
            dao.delete(a);   // limpa o banco, mesmo se o teste falhar
        }
    }
}
