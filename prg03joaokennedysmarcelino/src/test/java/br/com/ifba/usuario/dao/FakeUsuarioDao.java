/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author kennedy
 */
public class FakeUsuarioDao implements UsuarioIDao {

    private final List<Usuario> lista = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public Usuario save(Usuario u) {
        if (u.getId() == null) {
            u.setId(proximoId++);
        }
        lista.add(u);
        return u;
    }

    @Override
    public Usuario update(Usuario u) {
        return u;
    }

    @Override
    public void delete(Usuario u) {
        lista.remove(u);
    }

    @Override
    public Usuario findById(Long id) {
        return lista.stream()
                .filter(u -> Objects.equals(u.getId(), id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(lista);
    }

    @Override
    public Usuario findByLogin(String login) {

        return lista.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst()
                .orElseThrow(() -> new UsuarioNaoEncontradoException(login));
    }

    @Override
    public boolean existePorLogin(String login) {
        return lista.stream().anyMatch(u -> u.getLogin().equals(login));
    }

    @Override
    public List<Usuario> findByNome(String nome) {
        List<Usuario> r = new ArrayList<>();
        for (Usuario u : lista) {
            if (u.getPessoa().getNome().toLowerCase().contains(nome.toLowerCase())) {
                r.add(u);
            }
        }
        return r;
    }
}
