package utils;

import model.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Utils {
    public static void criarTabelaPersonagens() throws SQLException {
        Connection conexao = SQL.conectar();
        String script = "create table if not exists personagens("
                + "jogador varchar(80),"
                + "nome varchar(80),"
                + "tema varchar(40),"
                + "origem varchar(40),"
                + "idade int,"
                + "fisico int,"
                + "destreza int,"
                + "intelecto int,"
                + "consciencia int,"
                + "presenca int"
                + ")";
        
        try (PreparedStatement pst = conexao.prepareStatement(script)) {
            pst.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela personagens. Código de erro: "+e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão. Código de erro: "+e.getMessage());
            }
        }
    }
}
