/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author kennedy
 */
public class ValidarTeste {
    @Test
    void cpfValido_retornaTrue() {
        assertTrue(Validar.cpfValido("00100200304"));
    }

    @Test
    void cpfValido_vazio_retornaFalse() {
        assertFalse(Validar.cpfValido(""));
    }

    @Test
    void cpfValido_null_retornaFalse() {
        assertFalse(Validar.cpfValido(null));
    }

    @Test
    void senhaForte_comCincoCaracteres_retornaTrue() {
        assertTrue(Validar.senhaForte("12345678"));
    }

    @Test
    void senhaForte_menosQueMinimo_retornaFalse() {
        assertFalse(Validar.senhaForte("12345"));
    }

    @Test
    void senhaForte_null_retornaFalse() {
        assertFalse(Validar.senhaForte(null));
    }

    @Test
    void senhasIguais_iguais_retornaTrue() {
        assertTrue(Validar.senhasIguais("abc12", "abc12"));
    }

    @Test
    void senhasIguais_diferentes_retornaFalse() {
        assertFalse(Validar.senhasIguais("abc12", "abc13"));
    }

    @Test
    void nomeValido_nomeCompleto_retornaTrue() {
        assertTrue(Validar.nomeValido("Kennedy Santoa"));
    }

    @Test
    void nomeValido_nomeCurto_retornaFalse() {
        assertFalse(Validar.nomeValido("Ana"));
    }

    @Test
    void nomeValido_null_retornaFalse() {
        assertFalse(Validar.nomeValido(null));
    }
}
