package view;


import java.sql.SQLException;
import java.util.Scanner;

import controller.Comando;

import utils.Utils;

public class Main {
    public static void main(String[] args) throws SQLException {
        Utils.criarTabelaPersonagens();
        Scanner scan = new Scanner(System.in);
        Comando comando;
        
        do {
            comando = new Comando(scan.nextLine());
            comando.executar();
        } while(true);
    }
}
