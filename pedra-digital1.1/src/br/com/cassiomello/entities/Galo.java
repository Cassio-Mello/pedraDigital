package br.com.cassiomello.entities;
public class Galo {
    private String nomeCriador;
    private String cidade;
    private String anilha;
    private int peso;
    private double altura; 

    public Galo(String nomeCriador,String cidade, String anilha, int peso, double altura) {
        this.nomeCriador = nomeCriador;
        this.cidade = cidade;
        this.anilha = anilha;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNomeCriador() {
        return nomeCriador;
    }

    public String getCidade(){
        return cidade;
    }

    public String getAnilha() {
        return anilha;
    }

    public double getPeso() {
        return peso;
    }
    
    public double getAltura() {
        return altura;
    }
}

