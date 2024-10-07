package br.com.cassiomello.entities;

public class ParDeGalos {
    private Galo galo1;
    private Galo galo2;

    
    public ParDeGalos(Galo galo1, Galo galo2) {
        this.galo1 = galo1;
        this.galo2 = galo2;
    }


    public Galo getGalo1() {
        return galo1;
    }


    public Galo getGalo2() {
        return galo2;
    }

    @Override
    public String toString() {
        return "Galo Anilha: " + galo1.getAnilha() + " <<<...............X...............>>> " 
                + "Galo Anilha: " + galo2.getAnilha()
                + "\nCriador: " + galo1.getNomeCriador() + " <<<...............X...............>>> " 
                + "Criador: " + galo2.getNomeCriador()
                + "\nPeso (g): " + galo1.getPeso() + " <<<...............X...............>>> " 
                + "Peso (g): " + galo2.getPeso()
                + "\nAltura (cm): " + galo1.getAltura() + " <<<...............X...............>>> " 
                + "Altura (cm): " + galo2.getAltura() + "\n";
    }
}
