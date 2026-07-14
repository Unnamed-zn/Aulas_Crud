package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    private static final String url = "jdbc:mysql://localhost:3306/projeto_rpg";
    private static final String usuario = "root";
    private static final String senha = "@rcci_2etA";
    
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer conexão com o banco. Código de erro: "+e.getMessage());
            return null;
        }
    }
}
