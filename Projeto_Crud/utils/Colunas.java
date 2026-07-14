package utils;


public enum Colunas {
    JOGADOR("jogador"),
    NOME("nome"),
    TEMA("tema"),
    ORIGEM("origem"),
    IDADE("idade"),
    FISICO("fisico"),
    DESTREZA("destreza"),
    INTELECTO("intelecto"),
    CONSCIENCIA("consciencia"),
    PRESENCA("presenca");
    
    private final String campo;
    
    Colunas(String campo) {
        this.campo = campo;
    }
    
    public String getCampo() {
        return campo;
    }
    
    public static boolean contains(String campoAlvo) {
        for (Colunas coluna : Colunas.values()) {
            if (coluna.campo.equalsIgnoreCase(campoAlvo)) return true;
        }
        return false;
    } 
    
}
