/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

/**
 *
 * @author kennedy
 */
public class UsuarioBasico extends Usuario{
    public UsuarioBasico(Pessoa pessoa, String login, String senha) {
        super(pessoa, login, senha);
    }

    @Override
    public String getNivelAcesso() {
        return "BASICO";
    }
}
