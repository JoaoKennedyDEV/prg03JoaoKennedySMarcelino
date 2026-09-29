/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.util;

import br.com.ifba.usuario.interfaces.Autenticavel;

/**
 *
 * @author kennedy
 */
public class ProcessoDeAcesso {
    
    public static String processar(Autenticavel pessoa, String login, String senha) {
        return pessoa.autenticar(login, senha);
    }
}
