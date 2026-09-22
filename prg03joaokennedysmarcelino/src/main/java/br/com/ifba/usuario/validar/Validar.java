/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;


/**
 *
 * @author kennedy
 */
public class Validar {
    public static boolean contemPalavraProibida(String texto){
        String[] palavras = {"senha","senha123","login","admin","teste"};
        for(String palavra:palavras){
            if(texto.equalsIgnoreCase(palavra)){
                return true;
            }
        }
        return false;
    }  
    public static boolean nomeValido(String nome) {
        return nome != null && nome.trim().length() >= 8;
    }

    public static boolean cpfValido(String cpf) {
        return cpf != null && cpf.length() >= 9;
    }

    public static boolean dataNascimentoValida(String data) {
        return data != null && data.length() >= 6;
    }

    public static boolean telefoneValido(String telefone) {
        return telefone != null && telefone.length() >= 11;
    }

    public static boolean loginValido(String login) {
        return login != null && login.length() >= 5;
    }

    public static boolean senhaForte(String senha) {
        return senha != null && senha.length() >= 8;
    }

    public static boolean senhasIguais(String senha, String confirmacao) {
        return senha != null && senha.equals(confirmacao);
    }
}

