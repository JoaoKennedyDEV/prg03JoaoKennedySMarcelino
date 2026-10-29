package br.com.ifba.usuario.entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kennedy
 */
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.usuario.interfaces.Autenticavel;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario extends PersistenceEntity implements Autenticavel{
    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;
    @Transient
    private List<Perfil> perfis;
    @Transient
    private Perfil perfilAtivo; 
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(unique = true, nullable = false)
    private String login;
    private String senha;

    
    
    public Usuario(){
        this.perfis = new ArrayList<>();
    }
    
    public Usuario(Pessoa pessoa,String login,String senha){
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
        this.perfis = new ArrayList<>();
        this.status = Status.INATIVO;
    }
    
    public Usuario(Pessoa pessoa, String login, String senha, Perfil perfilInicial) {
        this(pessoa, login, senha);
        adicionarPerfil(perfilInicial);
    }
    
    public void adicionarPerfil(Perfil perfil) {
        this.perfis.add(perfil);
        if(this.perfilAtivo == null){
            this.perfilAtivo = perfil;
        }
    }
    
    // login é a chave de acesso do sistema e é único por usuario
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario outro = (Usuario) o;
        return Objects.equals(login, outro.login);
    }
    
    public Pessoa getPessoa() {
        return pessoa; 
    }
    
    public void setPessoa(Pessoa pessoa) { 
        this.pessoa = pessoa; 
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Status getStatus() { 
        return status; 
    }
    
    public void setStatus(Status status) {
        this.status = status; 
    }
    
    public List<Perfil> getPerfis() {
        return Collections.unmodifiableList(perfis);
    }
    
    public Perfil getPerfilAtivo() { 
        return perfilAtivo; 
    }
    
    public String getNivelAcesso() {
        return "PADRAO";
    }
    
    @Override
    public String autenticar(String login, String senha) {
        if (this.login.equals(login) && this.senha.equals(senha)) {
                return "Bem-vindo, " + login;
        }
        return "Acesso negado";
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
    
}
