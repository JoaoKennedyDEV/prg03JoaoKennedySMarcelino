/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.repository;

/**
 *
 * @author kennedy
 */
import br.com.ifba.infrastructure.util.JPAUtil;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.exception.ErroDePersistenciaException;
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;
import jakarta.persistence.EntityManager;
import java.util.List;

public class RepositorioUsuarioJpa {

    // ---------- CREATE (persist) ----------
    public void cadastrar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();   // Task 06
            }
            throw new ErroDePersistenciaException("Não foi possível salvar o usuário", e);
        } finally {
            em.close();                           // Task 06
        }
    }

    // ---------- READ (find) ----------
    // Task 04: lança a exceção em vez de devolver null
    public Usuario buscarPorLogin(String login) {
        EntityManager em = JPAUtil.getEntityManager();
        Usuario usuario;
        try {
            usuario = em.find(Usuario.class, login);
        } catch (RuntimeException e) {
            throw new ErroDePersistenciaException("Não foi possível buscar o usuário", e);
        } finally {
            em.close();
        }
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException(login);
        }
        return usuario;
    }

    // consulta de existência (usada na validação de login duplicado)
    public boolean existePorLogin(String login) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Usuario.class, login) != null;
        } catch (RuntimeException e) {
            throw new ErroDePersistenciaException("Não foi possível consultar o login", e);
        } finally {
            em.close();
        }
    }

    // ---------- READ (listar) ----------
    public List<Usuario> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("select u from Usuario u", Usuario.class)
                     .getResultList();
        } catch (RuntimeException e) {
            throw new ErroDePersistenciaException("Não foi possível listar os usuários", e);
        } finally {
            em.close();
        }
    }

    // ---------- READ (JPQL com where) : Task 07 ----------
    public List<Usuario> buscarPorNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                        "select u from Usuario u where lower(u.pessoa.nome) like :nome",
                        Usuario.class)
                     .setParameter("nome", "%" + nome.toLowerCase() + "%")
                     .getResultList();
        } catch (RuntimeException e) {
            throw new ErroDePersistenciaException("Não foi possível buscar por nome", e);
        } finally {
            em.close();
        }
    }

    // ---------- UPDATE (merge) ----------
    public void atualizar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            if (em.find(Usuario.class, usuario.getLogin()) == null) {
                throw new UsuarioNaoEncontradoException(usuario.getLogin());
            }
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (UsuarioNaoEncontradoException e) {
            throw e;   // ainda não havia transação aberta
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new ErroDePersistenciaException("Não foi possível atualizar o usuário", e);
        } finally {
            em.close();
        }
    }

    // ---------- DELETE (find + remove) ----------
    public void remover(String login) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Usuario usuario = em.find(Usuario.class, login);   // precisa ser gerenciado
            if (usuario == null) {
                throw new UsuarioNaoEncontradoException(login);
            }
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (UsuarioNaoEncontradoException e) {
            throw e;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new ErroDePersistenciaException("Não foi possível remover o usuário", e);
        } finally {
            em.close();
        }
    }
}