/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.validar;


/**
 *
 * @author kennedy
 */
public class validar {
    public static boolean contemPalavraProibida(String texto){
        String[] palavras = {"senha","senha123","login","admin","teste"};
        for(String palavra:palavras){
            if(texto.equalsIgnoreCase(palavra)){
                return true;
            }
        }
        return false;
    }  
}

