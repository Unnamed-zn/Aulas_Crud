package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.Acesso;
import model.Personagem;
import utils.Colunas;

public class Comando {
    private String comando;
    
    private List<String> parametros;
    
    private Acesso acesso = new Acesso();
    
    private String acao;
    private String personagemAlvo;
    private String colunaAlvo;
    private String valorParametro;
    private String novoValor;
    
    
    public Comando(String comando) {
        this.comando = comando;
        if (parametros!=null) {
            parametros.clear();
        }
        String[] comandoArray = comando.split(" ");
        parametros = new ArrayList<>(Arrays.asList(comandoArray));
        this.acao = parametros.get(0);
    }
    
    public void setComando(String comando) {
        this.comando = comando;
        parametros.clear();
        parametros = new ArrayList<>(Arrays.asList(comando));
    }
    
    /*
      Para organização:
      [0] = ação;
      [1] = personagem alvo / coluna parametro (pesquisas);
      [2] = coluna alvo / valor parametro (pesquisas);
      [3] = novo valor;
    */
    
    
    public void executar() throws SQLException {
        parametros.set(0, parametros.get(0).toLowerCase());
        
        switch (this.acao) {
            case "!criarpersonagem":
                criarPersonagem();
                return;
            case "!atualizar":
                atualizar();
                return;
            default:
                return;
        }
    }
    
    private void criarPersonagem() throws SQLException {
        Scanner scan = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        
        System.out.println("Iniciando montagem de personagem...\n");
        
        System.out.print("Digite o nome do jogador dono do personagem.\n-> ");
        String jogador = scan.nextLine();
        while (jogador.equals("")) {
            System.out.println("Jogador é um campo essencial para diferenciar personagens, não podendo ser nulo.\nDigite um valor válido.");
            System.out.print("Digite o nome do jogador.\n-> ");
            jogador = scan.nextLine();
        }
        System.out.println("Nome do jogador definido como '"+jogador+"'.");
        
        System.out.print("Digite o nome do personagem.\n-> ");
        String nomePersonagem = scan.nextLine();
        if (nomePersonagem.equals("")) {
            System.out.println("Deixar o nome de um personagem vazio é uma prática não recomendada, pois dificulta o reconhecimento.");
            System.out.println("Tem certeza que deseja deixar o nome vazio? (s/n)");
            String escolha;
            do { 
                escolha = scan.nextLine().toLowerCase();
                
                switch (escolha) {
                    case "s":
                        System.out.println("Personagem definido sem nome declarado.\n");
                        break;
                    case "n":
                        System.out.print("Digite um nome de personagem válido. (deixar o nome vazio novamente o definirá sem nome)\n-> ");
                        nomePersonagem = scan.nextLine();
                        if (nomePersonagem.equals("")) {
                            System.out.println("Personagem definido sem nome declarado.\n");
                        } else {
                            System.out.println("Personagem definido com o nome '"+nomePersonagem+"'.\n");
                        }
                        break;
                    default:
                        System.out.println("Escolha inválida, tente novamente.");
                        System.out.print("Deseja deixar o nome vazio? (s/n)\n-> ");
                        break;
                }
            } while (!escolha.equals("s") || !escolha.equals("n"));
        } else {
            System.out.println("Personagem definido com o nome '"+nomePersonagem+"'.");
        }
        
        nomePersonagem = nomePersonagem.replace(" ", "_");
        
        System.out.print("Digite o tema do personagem. (pressione 'enter' para prosseguir sem definir.)\n-> ");
        String tema = scan.nextLine();
        if (tema.equals("")) tema = "_"; 
        
        System.out.print("Digite a origem do personagem. (pressione 'enter' para prosseguir sem definir.)\n-> ");
        String origem = scan.nextLine();
        if (origem.equals("")) origem = "_";
        
        System.out.print("Digite a idade do personagem. (apenas números, pressione 'enter' para definir como o padrão(18).)\n-> ");
        String idadeSt = scan.nextLine();
        int idade;
        try {
            idade = Integer.parseInt(idadeSt);
            if (idade<=0) {
                System.out.println("Valor digitado negativo, idade definida automaticamente ocmo 18 anos.");
            } else {
                System.out.println("Idade definida como "+idade+" anos.");
            }
        } catch (NumberFormatException e) {
            if (idadeSt.equals("")) {
                System.out.println("Definindo idade para 18.");
            } else {
                System.out.println("Valor digitado inválido, a idade foi definida como 18 automaticamente.");
            }
            idade = 18;
        }
        
        System.out.print("Digite o valor de 'Físico' do personagem. (valores inteiros, pressione 'enter' para definir como 0.)\n-> ");
        String fisicoSt = scan.nextLine();
        int fisico;
        try {
            fisico = Integer.parseInt(fisicoSt);
            System.out.println("Valor de atributo definido.");
        } catch (NumberFormatException e1) {
            if (fisicoSt.equals("")) {
                System.out.println("Definindo atributo para 0.");
            } else {
                System.out.println("Valor digitado inválido, atributo definido como 18 automaticamente.");
            }
            fisico = 0;
        }
            
        System.out.print("Digite o valor de 'Destreza' do personagem. (valores inteiros, pressione 'enter' para definir como 0.)\n-> ");
        String destrezaSt = scan.nextLine();
        int destreza;
        try {
            destreza = Integer.parseInt(destrezaSt);
            System.out.println("Valor de atributo definido.");
        } catch (NumberFormatException e2) {
            if (destrezaSt.equals("")) {
                System.out.println("Definindo atributo para 0.");
            } else {
                System.out.println("Valor digitado inválido, atributo definido como 18 automaticamente.");
            }
            destreza = 0;
        }
        
        System.out.print("Digite o valor de 'Intelecto' do personagem. (valores inteiros, pressione 'enter' para definir como 0.)\n-> ");
        String intelectoSt = scan.nextLine();
        int intelecto;
        try {
            intelecto = Integer.parseInt(intelectoSt);
            System.out.println("Valor de atributo definido.");
        } catch (NumberFormatException e1) {
            if (intelectoSt.equals("")) {
                System.out.println("Definindo atributo para 0.");
            } else {
                System.out.println("Valor digitado inválido, atributo definido como 18 automaticamente.");
            }
            intelecto = 0;
        }
        
        System.out.print("Digite o valor de 'Consciência' do personagem. (valores inteiros, pressione 'enter' para definir como 0.)\n-> ");
        String conscienciaSt = scan.nextLine();
        int consciencia;
        try {
            consciencia = Integer.parseInt(conscienciaSt);
            System.out.println("Valor de atributo definido.");
        } catch (NumberFormatException e1) {
            if (conscienciaSt.equals("")) {
                System.out.println("Definindo atributo para 0.");
            } else {
                System.out.println("Valor digitado inválido, atributo definido como 18 automaticamente.");
            }
            consciencia = 0;
        }
        
        System.out.print("Digite o valor de 'Presença' do personagem. (valores inteiros, pressione 'enter' para definir como 0.)\n-> ");
        String presencaSt = scan.nextLine();
        int presenca;
        try {
            presenca = Integer.parseInt(presencaSt);
            System.out.println("Valor de atributo definido.");
        } catch (NumberFormatException e1) {
            if (presencaSt.equals("")) {
                System.out.println("Definindo atributo para 0.");
            } else {
                System.out.println("Valor digitado inválido, atributo definido como 18 automaticamente.");
            }
            presenca = 0;
        }
        
        Personagem personagem = new Personagem(jogador, nomePersonagem, tema, origem, idade, fisico, destreza, intelecto, consciencia, presenca);
        
        System.out.println("Personagem criado para o jogador '"+jogador+"'.");
        
        acesso.inserir(personagem);
    }
    
    private void atualizar() throws SQLException {
        this.personagemAlvo = parametros.get(1);
        this.colunaAlvo = parametros.get(2);
        this.novoValor = parametros.get(3);
        
        if (!Colunas.contains(colunaAlvo)) {
            System.out.println("Coluna alvo inválida para atualização, verifique a sintaxe do comando e a ortografia.");
            return;
        }
        
        if (Colunas.isInt(colunaAlvo)) {
            try {
                int novoValorInt = Integer.parseInt(novoValor);
                acesso.atualizar(personagemAlvo, colunaAlvo, novoValorInt);
            } catch (NumberFormatException e) {
                System.out.println("A coluna alvo é restrita a inteiros, o parâmetro do novo valor é alfabético, racional ou alfanumérico.");
            }
        } else {
            acesso.atualizar(personagemAlvo, colunaAlvo, novoValor);
        }
    }
}
