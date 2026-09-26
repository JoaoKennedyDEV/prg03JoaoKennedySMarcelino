/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

/**
 *
 * @author kennedy
 */
public class UsuarioAdmin extends Usuario{
    public UsuarioAdmin(Pessoa pessoa, String login, String senha) {
        super(pessoa, login, senha);
    }

    @Override
    public String getNivelAcesso() {
        return "ADMIN";
    }

    public void gerenciarUsuarios() {
        System.out.println("Acesso liberado ao painel de gerenciamento de usuários.");
    }
}
