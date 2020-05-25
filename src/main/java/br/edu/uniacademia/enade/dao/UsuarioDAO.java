/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.dao;

import br.edu.uniacademia.enade.model.TbUsuario;
import java.io.Serializable;

/**
 *
 * @author tassi
 */
public class UsuarioDAO extends GenericDAO<TbUsuario, Long> implements Serializable {
    
    public static UsuarioDAO usuarioDAO;
    
    public UsuarioDAO() {
        super(TbUsuario.class);
    }
    
    public static UsuarioDAO getInstance() {
    
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    }
    
}
