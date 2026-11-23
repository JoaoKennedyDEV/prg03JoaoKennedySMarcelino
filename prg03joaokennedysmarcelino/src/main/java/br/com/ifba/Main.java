/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

import br.com.ifba.login.view.Login;
import br.com.ifba.usuario.controller.UsuarioController;
import br.com.ifba.usuario.controller.UsuarioIController;
import br.com.ifba.usuario.dao.PessoaDao;
import br.com.ifba.usuario.dao.PessoaIDao;
import br.com.ifba.usuario.dao.UsuarioDao;
import br.com.ifba.usuario.dao.UsuarioIDao;
import br.com.ifba.usuario.service.UsuarioIService;
import br.com.ifba.usuario.service.UsuarioService;
/**
 *
 * @author kennedy
 */


public class Main {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        UsuarioIDao usuarioDao = new UsuarioDao();
        PessoaIDao pessoaDao = new PessoaDao();
        UsuarioIService service = new UsuarioService(usuarioDao, pessoaDao);
        UsuarioIController controller = new UsuarioController(service);

        java.awt.EventQueue.invokeLater(() -> new Login(controller).setVisible(true));
    }
}