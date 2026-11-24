/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.service;

/**
 *
 * @author kennedy
 */
import br.com.ifba.usuario.dao.PessoaIDao;
import br.com.ifba.usuario.dao.UsuarioIDao;
import br.com.ifba.usuario.entity.Pessoa;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.validar.Validar;
import java.util.List;
import br.com.ifba.infrastructure.exception.NegocioException;

public class UsuarioService implements UsuarioIService {

    private final UsuarioIDao dao;
    private final PessoaIDao pessoaDao;

    public UsuarioService(UsuarioIDao dao, PessoaIDao pessoaDao) {
        this.dao = dao;
        this.pessoaDao = pessoaDao;
    }

    @Override
    public Usuario save(Usuario usuario) {
        if (usuario == null || usuario.getPessoa() == null) {
            throw new NegocioException("Dados do usuário não informados");
        }
        Pessoa pessoa = usuario.getPessoa();

        if (!Validar.nomeValido(pessoa.getNome())) {
            throw new NegocioException("Digite um nome válido (mínimo 8 caracteres)");
        }
        if (!Validar.cpfValido(pessoa.getCpf())) {
            throw new NegocioException("Campo de CPF está incompleto");
        }
        if (!Validar.dataNascimentoValida(pessoa.getDataNascimento())) {
            throw new NegocioException("Data de nascimento está incompleta");
        }
        if (!Validar.telefoneValido(pessoa.getTelefone())) {
            throw new NegocioException("Número de telefone está incompleto");
        }
        if (!Validar.loginValido(usuario.getLogin())) {
            throw new NegocioException("Login incorreto: mínimo de 5 caracteres");
        }
        if (!Validar.senhaForte(usuario.getSenha())) {
            throw new NegocioException("Senha: mínimo de 8 caracteres");
        }
        if (Validar.contemPalavraProibida(usuario.getLogin())) {
            throw new NegocioException("Login contém palavra não permitida");
        }
        if (dao.existePorLogin(usuario.getLogin())) {
            throw new NegocioException("Login já existe");
        }
        if (pessoaDao.findByCpf(pessoa.getCpf()) != null) {
            throw new NegocioException("CPF já cadastrado");
        }

        return dao.save(usuario);   // só chega aqui se passou em tudo
    }

    @Override
    public Usuario update(Usuario usuario) {
        if (usuario == null || usuario.getPessoa() == null) {
            throw new NegocioException("Dados do usuário não informados");
        }
        Pessoa pessoa = usuario.getPessoa();

        if (!Validar.nomeValido(pessoa.getNome())) {
            throw new NegocioException("Digite um nome válido (mínimo 8 caracteres)");
        }
        if (!Validar.dataNascimentoValida(pessoa.getDataNascimento())) {
            throw new NegocioException("Data de nascimento está incompleta");
        }
        if (!Validar.telefoneValido(pessoa.getTelefone())) {
            throw new NegocioException("Número de telefone está incompleto");
        }
        if (!Validar.senhaForte(usuario.getSenha())) {
            throw new NegocioException("Senha: mínimo de 8 caracteres");
        }

        return dao.update(usuario);
    }
    
    @Override
    public void delete(Usuario usuario) {
        dao.delete(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return dao.findAll();
    }

    @Override
    public Usuario findByLogin(String login) {
        return dao.findByLogin(login);
    }

    @Override
    public List<Usuario> findByNome(String nome) {
        return dao.findByNome(nome);
    }
}