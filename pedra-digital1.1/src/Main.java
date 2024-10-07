import java.util.Scanner;

import br.com.cassiomello.entities.GerenciadorDeGalos;

public class Main {
    public static void main(String[] args) {

        GerenciadorDeGalos gerenciador = new GerenciadorDeGalos();

        Scanner scanner = new Scanner(System.in);
       
        //variável de opções do menu
        int opcao = 0;
        

        System.out.println("...::BEM VINDO AO PEDRA DIGITAL::...");
        System.out.println("------------------------------------");
        
        //loop do sistema
        while (opcao != 7) {
            
            //loop de validação de entrada
            while (true){

                System.out.println("...::Informe a opção desejada::...");
                System.out.println("----------------------------------");
                System.out.println("| 1.Cadastrar                    |");
                System.out.println("|                                |");
                System.out.println("| 2.Listar Todos os Galos        |");
                System.out.println("|                                |");
                System.out.println("| 3.Emparelhar                   |");
                System.out.println("|                                |");
                System.out.println("| 4.Listar Parelhas              |");
                System.out.println("|                                |");
                System.out.println("| 5.Sortear Ordem das Rinhas     |");
                System.out.println("|                                |");
                System.out.println("| 6.Remover Galo                 |");
                System.out.println("|                                |");
                System.out.println("| 7.Sair                         |");
                System.out.println("----------------------------------");

                //variavel para verificação de entrada
                String opcaoInput = scanner.nextLine();

                //verificação de entrada
                try{
                    opcao = Integer.parseInt(opcaoInput);
                    //ferica se opção digitada é valida
                    if (opcao <= 0 || opcao > 7){
                        gerenciador.clearScreen();
                        System.out.println("...::OPÇÃO INVÁLIDA::...");
                        continue;
                    }
                    break;
                //testa se aentrada é um número
                }catch (NumberFormatException e){
                    gerenciador.clearScreen();
                    System.out.println("...::ENTRADA INVÁLIDA::...");
                }
            
            }

            
            //menu
            switch (opcao){

                //cadastra galos
                case 1 :
                    gerenciador.clearScreen();
                    System.out.println("...::CADASTRAR GALOS::...");
                    gerenciador.cadastrarGalos(scanner);
                    break;
                
                //lista os galos cadastrados
                case 2:
                    gerenciador.clearScreen();
                    gerenciador.listarGalos();
                    break;
                    
                 //faz a comparaçao, exibe as parelhas encontradas e os galos que ficaram sem parelha   
                case 3:
                    gerenciador.clearScreen();
                    gerenciador.compararGalos();
                    System.out.println("...::Galos sem parelha:::...");
                    gerenciador.imprimirGalosSemParelha();
                    break;

                //lista as parelhas de galos
                case 4:
                    gerenciador.clearScreen(); 
                    gerenciador.listarGalosEmparelhados();                  
                    break;

                //faz o sorteio de ordem das rinhas
                case 5:
                    gerenciador.clearScreen();                    
                    gerenciador.sortearOrdemRinhas();
                    break;

                //remove um galo cadastrado pela anilha (remove de todas as listas que o mesmo estiver)
                //se o galo removido estava em uma parelha o seu adversario vai para a lista de sem parelha
                case 6:
                    gerenciador.clearScreen();                    
                    System.out.println("Informe a anilha do galo que deseja remover:");
                    String anilha = scanner.nextLine();
                    gerenciador.removerGalo(anilha);
                    break;

                //sai do sistema
                case 7:
                    gerenciador.clearScreen();
                    System.out.println("Você deseja realmente SAIR: [S]im  [N]ão");
                    String sair = scanner.nextLine();
                    gerenciador.clearScreen();

                    if (sair.equalsIgnoreCase("s")){
                        opcao = 7;
                        System.out.println("...::Você saiu do programa::...");
                    
                    }else{
                        opcao = 0;//reseta para continuar no loop
                    }
                    break;

                default:
                    System.out.println("...::Opção inválida tente novamente::...");
                    break;

                        
            }

        }
        scanner.close();
        
    }
}