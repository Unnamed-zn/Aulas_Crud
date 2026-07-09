package controller;
import Model.Usuario;
import Model.dao.Dao;

import java.util.List;

public class UsuarioController {
    private Dao dao = new Dao();
    
    public void adicionarUsuario(String nome, String email){
        dao.inserirUsuario(nome,email);
    }
    
    public void atualizarUsuario (String nome, String novoEmail){
        dao.atualizarUsuario(nome, novoEmail);
    }
    
    public void deletarUsuario(String nome){
        dao.deletarUsuario(nome);
    }
    
    public List<Usuario> listarUsuarios(){
        return dao.listarUsuarios();
    }
}