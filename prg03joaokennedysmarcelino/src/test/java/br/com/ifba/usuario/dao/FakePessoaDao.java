/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.usuario.entity.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author kennedy
 */

public class FakePessoaDao implements PessoaIDao {

    private final List<Pessoa> lista = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public Pessoa save(Pessoa p) {
        if (p.getId() == null) {
            p.setId(proximoId++);
        }
        lista.add(p);
        return p;
    }

    @Override
    public Pessoa update(Pessoa p) { return p; }

    @Override
    public void delete(Pessoa p) { lista.remove(p); }

    @Override
    public Pessoa findById(Long id) {
        return lista.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Pessoa> findAll() { return new ArrayList<>(lista); }

    @Override
    public Pessoa findByCpf(String cpf) {
        return lista.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst().orElse(null);   // igual ao DAO real: null se não achar
    }
}