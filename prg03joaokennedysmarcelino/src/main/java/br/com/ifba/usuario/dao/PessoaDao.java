/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.infrastructure.exception.ErroDePersistenciaException;
import br.com.ifba.infrastructure.util.JPAUtil;
import br.com.ifba.usuario.entity.Pessoa;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author kennedy
 */
public class PessoaDao extends GenericDao <Pessoa> implements PessoaIDao {

    public PessoaDao() {
        super(Pessoa.class);
    }

    @Override
    public Pessoa findByCpf(String cpf) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<Pessoa> r = em.createQuery(
                    "SELECT p FROM Pessoa p WHERE p.cpf = :cpf", Pessoa.class)
                .setParameter("cpf", cpf)
                .getResultList();
            return r.isEmpty() ? null : r.get(0);
        } catch (RuntimeException e) {
            throw new ErroDePersistenciaException("Não foi possível buscar por CPF", e);
        } finally {
            em.close();
        }
    }
}