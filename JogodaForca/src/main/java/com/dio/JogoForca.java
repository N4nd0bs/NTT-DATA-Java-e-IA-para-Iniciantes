package com.dio;

public class JogoForca {
    private int vidas = 6;
    private final String[] palavras = {"cruzeiro", "elefante", "garrafa"};

    public void setVida(int vidas){
        this.vidas = vidas;
    }

    public int getVida(){
        return vidas;
    }

    public String[] getWord(){
        return palavras;
    }
}
