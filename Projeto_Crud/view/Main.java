package view;

import java.sql.SQLException;
import java.util.Scanner;

import utils.Utils;

public class Main {
    public static void main(String[] args) throws SQLException {
        Utils.criarTabelaPersonagens();
        Scanner scan = new Scanner(System.in);
        String comando;
        do {
            comando = scan.nextLine();
        } while(true);
        
    }
}
