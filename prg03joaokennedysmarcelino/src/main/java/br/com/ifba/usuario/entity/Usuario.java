package br.com.ifba.usuario.entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kennedy
 */
import br.com.ifba.usuario.interfaces.Autenticavel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario implements Autenticavel{
    private Pessoa pessoa;
    private List<Perfil> perfis;
    private Perfil perfilAtivo; 
    private Status status;
    private String login;
    private String senha;

    
    
    public Usuario(){
    }
    
    public Usuario(Pessoa pessoa,String login,String senha){
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
        this.perfis = new ArrayList<>();
        this.status = Status.INATIVO;
    }
    
    public void adicionarPerfil(Perfil perfil) {
        this.perfis.add(perfil);
        if(this.perfilAtivo == null){
            this.perfilAtivo = perfil;
        }
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

    public String getSenha() {
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
    
    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
    
}
