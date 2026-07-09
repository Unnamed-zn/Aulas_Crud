package Util;

import Model.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author LUISGUILHERMEDESOUZA
 */

public class BancoUtils {
    public static void criarTabelaUsuarios() {
        Connection conexao = ConexaoBD.getConexao();
        if (conexao != null) {
            String sql = "create table if not exists usuarios("
                    + "id int auto_increment primary key,"
                    + "nome varchar(100),"
                    + "email varchar(100)"
                    + ");";
            try (PreparedStatement pst = conexao.prepareStatement(sql)) {
                pst.execute();
                System.out.println("Tabela 'usuarios' criada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao criar tabela 'usuarios': " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch(SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
}