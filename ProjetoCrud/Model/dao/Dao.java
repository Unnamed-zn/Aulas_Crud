package Model.dao;

import Model.ConexaoBD;
import Model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LUISGUILHERMEDESOUZA
 */

public class Dao {

    //Inserir Usuário
    public void inserirUsuario(String nome, String email) {
        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sql = "insert into usuarios (nome, email) values (?,?)";
            try (PreparedStatement pst = conexao.prepareStatement(sql)) {
                pst.setString(1, nome);
                pst.setString(2, email);
                pst.executeUpdate();
                System.out.println("Usuário inserido com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao inserir o usuário: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }

    //Atualizar Usuário
    public void atualizarUsuario(String nome, String novoEmail) {
        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sql = "update usuarios set email = ? where nome = ?";
            try (PreparedStatement pst = conexao.prepareStatement(sql)) {
                pst.setString(1, novoEmail);
                pst.setString(2, nome);
                pst.executeUpdate();
                System.out.println("Usuário atualizado com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar o usuário: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }

    //Deletar Usuário
    public void deletarUsuario(String nome) {
        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sql = "delete from usuarios where nome = ?";
            try (PreparedStatement pst = conexao.prepareStatement(sql)) {
                pst.setString(1, nome);
                pst.executeUpdate();
                System.out.println("Usuário deletado com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao deletar o usuário: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }

    //Listar Usuário
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sql = "select * from usuarios";
            try (PreparedStatement pst = conexao.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
                System.out.println("Lista de Usuários: ");
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuarios.add(usuario);
                   // System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao listar os usuários: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
        return usuarios;
    }
}