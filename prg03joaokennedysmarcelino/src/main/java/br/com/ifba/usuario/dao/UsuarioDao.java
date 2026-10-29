/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.dao;

import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.infrastructure.exception.ErroDePersistenciaException;
import br.com.ifba.infrastructure.util.JPAUtil;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author kennedy
 */
public class UsuarioDao extends GenericDao<Usuario> implements UsuarioIDao {

    public UsuarioDao() { super(Usuario.class); }

    @Override
    public Usuario findByLogin(String login) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Usuario> r;
        try {
            r = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class)
                  .setParameter("login", login).getResultList();
        } catch (RuntimeException e) {
            throw new ErroDePersistenciaException("Erro ao buscar usuário", e);
        } finally {
            em.close();
        }
        if (r.isEmpty()) throw new UsuarioNaoEncontradoException(login);
        return r.get(0);
    }

    @Override
    public boolean existePorLogin(String login) {
        try { findByLogin(login); return true; }
        catch (UsuarioNaoEncontradoException e) { return false; }
    }

    @Override
    public List<Usuario> findByNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u WHERE LOWER(u.pessoa.nome) LIKE :nome", Usuario.class)
                .setParameter("nome", "%" + nome.toLowerCase() + "%").getResultList();
        } catch (RuntimeException e) {
            throw new ErroDePersistenciaException("Erro ao buscar por nome", e);
        } finally {
            em.close();
        }
    }
}