package model;

public class Personagem {
    private int id;
    private String jogador, nome, tema, origem;
    private int idade, fisico, destreza, intelecto, consciencia, presenca, pontosDeVida, pontosDeEspirito, pontosDeAcao, pontosDeDestino;

    public Personagem() {
    }

    public Personagem(String jogador, String nome, String tema, String origem, int idade, int fisico, int destreza, int intelecto, int consciencia, int presenca) {
        this.jogador = jogador;
        this.nome = nome;
        this.tema = tema;
        this.origem = origem;
        this.idade = idade;
        this.fisico = fisico;
        this.destreza = destreza;
        this.intelecto = intelecto;
        this.consciencia = consciencia;
        this.presenca = presenca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getJogador() {
        return jogador;
    }
    
    public void setJogador (String jogador) {
        this.jogador = jogador;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getFisico() {
        return fisico;
    }

    public void setFisico(int fisico) {
        this.fisico = fisico;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getIntelecto() {
        return intelecto;
    }

    public void setIntelecto(int intelecto) {
        this.intelecto = intelecto;
    }

    public int getConsciencia() {
        return consciencia;
    }

    public void setConsciencia(int consciencia) {
        this.consciencia = consciencia;
    }

    public int getPresenca() {
        return presenca;
    }

    public void setPresenca(int presenca) {
        this.presenca = presenca;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public int getPontosDeEspirito() {
        return pontosDeEspirito;
    }

    public int getPontosDeAcao() {
        return pontosDeAcao;
    }
    public int getPontosDeDestino() {
        return pontosDeDestino;
    }
    
}
