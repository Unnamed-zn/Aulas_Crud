package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class comando {
    private String comando;
    
    private List<String> parametros;
    
    private String acao;
    private String personagemAlvo;
    private String colunaAlvo;
    private String valorParametro;
    private String novoValor;
    
    public comando(String comando) {
        this.comando = comando;
        parametros.clear();
        parametros = new ArrayList<>(Arrays.asList(comando));
    }
    
    /* Para organização:
     * [0] = ação;
     * [1] = personagem alvo;
     * [2] = coluna alvo;
     * [3] = novo valor;
     * Em
    */
    
}
