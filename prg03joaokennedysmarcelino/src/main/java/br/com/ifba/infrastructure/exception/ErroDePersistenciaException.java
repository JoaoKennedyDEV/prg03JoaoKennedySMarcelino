/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.exception;

/**
 *
 * @author kennedy
 */
public class ErroDePersistenciaException extends RuntimeException {

    public ErroDePersistenciaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
