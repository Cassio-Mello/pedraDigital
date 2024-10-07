package br.com.cassiomello.entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class GerenciadorDeGalos {
    //atributos
    private List<Galo> galos;
    private List<Galo> galosComparados;
    private List<Galo> galosSemParelha;
    private List<ParDeGalos> galosEmparelhados;

    //construtor
    public GerenciadorDeGalos() {
        this.galos = new ArrayList<>();
        this.galosComparados = new ArrayList<>();
        this.galosSemParelha = new ArrayList<>();
        this.galosEmparelhados = new ArrayList<>();
    }

    //metodo para adicionar galo
    private void adicionarGalo(Galo galo) {
        galos.add(galo);
    }

    //metodo para comparar galos e montar parelhas. Este tembem adicona galos sem par a lista de sem parelha.
    public void compararGalos() {

        for (int i = 0; i < galos.size(); i++) {
            Galo galo1 = galos.get(i);

            //verificando se o galo ja foi comparado anteriormente
            if (galosComparados.contains(galo1)) {
                continue;
            }

            //variaves de comparaçao de galo mais proximo. E variaveis de limite de diferença de peso e altura.
            Galo galoMaisProximo = null;
            double menorDiferencaPeso = 50;
            double menorDiferencaAltura = 1.5;


            for (int j = i + 1; j < galos.size(); j++) {
                Galo galo2 = galos.get(j);

                //verificando se o galo já foi comparado e verificando se o galo a comparar nao é do mesmo criador.
                if (galosComparados.contains(galo2) || galo1.getNomeCriador().equals(galo2.getNomeCriador())) {
                    continue;
                }

                // Validando apenas 1 vantagem Peso maior ou altura maioe
                if (galo1.getPeso() > galo2.getPeso() && galo1.getAltura() > galo2.getAltura()){
                    continue;

                }else if (galo2.getPeso() > galo1.getPeso() && galo2.getAltura() > galo1.getAltura()){                    
                    continue;
                }

                //Variaveis para condiçao de diferença peso e altura
                double diferencaPeso = Math.abs(galo1.getPeso() - galo2.getPeso());
                double diferencaAltura = Math.abs(galo1.getAltura() - galo2.getAltura());

                //encontrando a menor diferença de peso e altura
                if (diferencaPeso <= 50 && diferencaPeso < menorDiferencaPeso && diferencaAltura <= 1 
                    && diferencaAltura < menorDiferencaAltura) {

                    //variaveis para armazer as menores diferenças de peso e altura e galo     
                    menorDiferencaPeso = diferencaPeso;
                    menorDiferencaAltura = diferencaAltura;
                    galoMaisProximo = galo2;

                }
            }

            //condição para imprimir as parelhas e adicionar os galos as listas
            if (galoMaisProximo != null) {                
                
                //impressao de parelha
                System.out.println("Galo: Anilha " + galo1.getAnilha() + " <<<...............X...............>>> " 
                                + "Galo Anilha: " + galoMaisProximo.getAnilha()
                                + "\nCriador: " + galo1.getNomeCriador() +" <<<...............X...............>>> " 
                                + "Criador: " + galoMaisProximo.getNomeCriador()
                                + "\nCidade: " + galo1.getCidade() + " <<<...............X...............>>> "  
                                + "Cidade: " + galoMaisProximo.getCidade()
                                + "\nPeso (g): " + galo1.getPeso() + " <<<...............X...............>>> " 
                                + "Peso (g): " + galoMaisProximo.getPeso()
                                + "\nAtura (cm) " + galo1.getAltura() + " <<<...............X...............>>> " 
                                + "Altura (cm): " + galoMaisProximo.getAltura()                                   
                                + "\n(Diferença de peso: " + menorDiferencaPeso + "g, Diferença de altura: " + menorDiferencaAltura + "cm)\n");
                
                //adicionando ambos a lista de galos comparados
                galosComparados.add(galo1);
                galosComparados.add(galoMaisProximo);
                
                //cria um novo par de galos e adiciona a lista de galos emparelhados
                galosEmparelhados.add(new ParDeGalos(galo1, galoMaisProximo));   
                
                //removendo galos da lista sem parelha que apos novas verificações encontraram parelha
                galosSemParelha.remove(galo1);
                galosSemParelha.remove(galoMaisProximo);
                
            }else{

                //adicionando um galo que não encontrou parelha a lista sem parelha
                if (!galosSemParelha.contains(galo1) ){
                    galosSemParelha.add(galo1);               
                }

            }

        }
    }

    //método para imprimir a lista de galos sem parelha
    public void imprimirGalosSemParelha(){

        for (int i = 0; i < galosSemParelha.size(); i++){
            System.out.println("Criador: " + galosSemParelha.get(i).getNomeCriador()
                            + "     Cidade: " + galosSemParelha.get(i).getCidade() 
                            + "     Anilha: " + galosSemParelha.get(i).getAnilha()
                            + "     Peso (g): " + galosSemParelha.get(i).getPeso()
                            + "     Altura (cm): " + galosSemParelha.get(i).getAltura());;

        }
    }

    //metodo para listas todos os galos cadastrados
    public void listarGalos(){

        for (int i = 0; i < galos.size(); i++){

            System.out.println("Criador: " + galos.get(i).getNomeCriador()
                            + "     Cidade: " + galos.get(i).getCidade() 
                            + "     Anilha: " + galos.get(i).getAnilha()
                            + "     Peso (g): " + galos.get(i).getPeso()
                            + "     Altura (cm): " + galos.get(i).getAltura() + "\n");

        }
    }

    //iniciamdo Scanner para o metodo de cadastro
    Scanner scanner = new Scanner(System.in);

    //metodo para cadastrar galos
    public void cadastrarGalos(Scanner scanner){

        //loop para cadastro
        while (true){
            
            //recebe nome e cidade do criador
            System.out.println("Digite o nome do criador:");
            String nomeCriador = scanner.nextLine();

            if (nomeCriador.equalsIgnoreCase("0")){
                break;
            }

            System.out.println("Informe a cidade:");
            String cidade = scanner.nextLine();

            //loop para caso desejar cadastrar mais galos ao mesmo criador
            while (true) {
   
                System.out.print("Digite a anilha do galo: ");
                String anilha = scanner.nextLine();
                
                //variáveis de peso e altura
                int peso = 0;
                double altura = 0;

                //loop para fazer a verificação de entrada de valor peso
                while (true){
                    
                    
                    System.out.print("Digite o peso do galo (em gramas): ");
                    String pesoInput = scanner.nextLine();

                    
                    try {  
                        peso = Integer.parseInt(pesoInput);

                        if (peso <= 0){
                            System.out.println("ATENÇÃO: PESO INVÁLIDO\n");
                            continue;
                        }
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("ATENÇÃO: ENTRADA INVÁLIDA\n");
                    }
                }
                
                //loop para fazer a verificação de entrada do valor altura
                while (true){
                    
                    System.out.print("Digite a altura do galo (em cm): ");
                    String alturaInput = scanner.nextLine();
                    
                    try {
                        altura = Double.parseDouble(alturaInput);
                        if (altura <= 0){
                            System.out.println("ATENÇÃO: PESO INVÁLIDO\n");
                            continue;
                        }
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("ATENÇÃO: ENTRADA INVÁLIDA\n");

                    }
                }

                //instanciando os valores coletados e adicioando a galo
                Galo galo = new Galo(nomeCriador, cidade, anilha, peso, altura);
                adicionarGalo(galo);

                //solicitação para adicionar outro galo ao mesmo criador
                System.out.print("Deseja adicionar outro galo para este criador? (s/n): ");                
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("n")) {
                    clearScreen();
                    break;
                    
                }

                clearScreen();
            }

            clearScreen();

            //solicita se deseja adicionar outro criador e galos
            System.out.print("Deseja adicionar galos de outro criador? (s/n): ");
            String respostaCriador = scanner.nextLine();
            
            if (respostaCriador.equalsIgnoreCase("n")) {
                
                clearScreen();
                break;
            }
            clearScreen();
        }
    }

    //metodo para remover galos cadastrados
    public void removerGalo(String anilha) {

        Galo galoRemover = null;
    
        // Encontrar o galo pela anilha
        for (Galo galo : galos) {

            if (galo.getAnilha().equals(anilha)) {
                galoRemover = galo;
                break;
            }
        }
        
        //retorna mesagem de nao encontrado 
        if (galoRemover == null) {
            System.out.println("...::Nenhum Galo Encontrado com essa Anilha::...\n");
            return;
        }
    
        //remove o galo da lista de galos
        galos.remove(galoRemover);
        System.out.println("...::Galo removido com sucesso::..\n");
    
        //remove o galo da lista de galos sem parelha
        galosSemParelha.remove(galoRemover);
    
        //remove o galo da lista de galos emparelhados e colocar o adversário de volta em galosSemParelha
        ParDeGalos parelhaRemover = null;
        
        for (ParDeGalos par : galosEmparelhados) {

            if (par.getGalo1().equals(galoRemover)) {
                galosSemParelha.add(par.getGalo2());
                parelhaRemover = par;
                break;

            } else if (par.getGalo2().equals(galoRemover)) {
                galosSemParelha.add(par.getGalo1());
                parelhaRemover = par;
                break;
            }
        }
    
        if (parelhaRemover != null) {
            galosEmparelhados.remove(parelhaRemover);
        }
    }
    
    //metodo para listar as parelhas de galos
    public void listarGalosEmparelhados() {

        if (galosEmparelhados.isEmpty()) {
            System.out.println("...::NÃO A PARELHAS PARA LISTAR::...\n");

        } else {
            System.out.println("Galos emparelhados:\n");
            
            for (ParDeGalos par : galosEmparelhados) {
                Galo galo1 = par.getGalo1();
                Galo galo2 = par.getGalo2();
                
                System.out.println("Galo Anilha: " + galo1.getAnilha() + " <<<...............X...............>>> " 
                                 + "Galo Anilha: " + galo2.getAnilha()
                                 + "\nCriador: " + galo1.getNomeCriador() + " <<<...............X...............>>> " 
                                 + "Criador: " + galo2.getNomeCriador()
                                 + "\nPeso (g): " + galo1.getPeso() + " <<<...............X...............>>> " 
                                 + "Peso (g): " + galo2.getPeso()
                                 + "\nAltura (cm): " + galo1.getAltura() + " <<<...............X...............>>> " 
                                 + "Altura (cm): " + galo2.getAltura() + "\n");
            }
        }
    }

    //metodo para sortear a ordem das rinhas atraves das parelhas
    public void sortearOrdemRinhas(){

        if (galosEmparelhados.isEmpty()){
            System.out.println("...::NENHUMA PARELHA ENCONTRADA::...");
            System.out.println();
            
        }else{
            System.out.println("...::ORDEM SORTEADAS DAS RINHAS::...");
            System.out.println();
            Collections.shuffle(galosEmparelhados);
            int ordem = 0;

            for (ParDeGalos parelha : galosEmparelhados){
                ordem++;
                System.out.println(ordem + "º Rinha");
                System.out.println(parelha);
            }
        }
    }

    public void clearScreen() {

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }

}
