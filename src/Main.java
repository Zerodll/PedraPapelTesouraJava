import java.util.Random;
import java.util.Scanner;

//Pedra, Papel e Tesoura
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String playerChoice;
        String machineChoice;
        String winner;
        String choice;
        int remainingTriesPlayer = 5;
        int remainingTriesMachine = 5;

        Random random = new Random();

        //‘Loop’ do jogo até que as tentativas sejam diferentes de 0
        do {

            while (true) {
                System.out.println("Jogo Pedra, Papel e Tesoura. Escolha um entre Pedra, Papel e Tesoura!");
                playerChoice = scanner.nextLine().toUpperCase();

                //Verifica a escolha do jogador
                if (playerChoice.equals("PEDRA")) {
                    break;
                } else if (playerChoice.equals("PAPEL")) {
                    break;
                } else if (playerChoice.equals("TESOURA")) {
                    break;
                } else {
                    System.out.println("Entrada inválida. Por favor, escolha uma opção válida.");
                }
            }

            //Verifica a escolha da máquina
            int randomChoice = random.nextInt(3);
            switch (randomChoice) {
                case 0:
                    machineChoice = "PEDRA";
                    break;
                case 1:
                    machineChoice = "PAPEL";
                    break;
                default:
                    machineChoice = "TESOURA";
            }

            System.out.println("\nA sua escolha é: " + playerChoice);
            System.out.println("A máquia escolheu: " + machineChoice);

            winner = winnerDetermine(playerChoice, machineChoice);

            //Determina o vencedor ou caso seja empate
            if (playerChoice.equals(winner)) {
                System.out.println("O vencedor é o Jogador!");
                remainingTriesMachine -= 1;
            }else if (machineChoice.equals(winner)){
                System.out.println("O vencedor é a Máquina!");
                remainingTriesPlayer -= 1;
            }else {
                playerChoice.equals(machineChoice); {
                    System.out.println("Empate!");
                }
            }

            //Determina caso o(a) jogador/máquina tem vidas para continuar jogando
            if (machineChoice.equals(winner) && remainingTriesPlayer == 0) {
                System.out.println("O jogo será finalizado, pois o jogador não tem mais vidas restantes!");
                break;
            } else if (playerChoice.equals(winner) && remainingTriesMachine == 0) {
                System.out.println("O jogo será finalizado, pois a máquina não tem mais vidas restantes!");
                break;
            }

            //Mostra a quantidade de vidas do jogador e a máquina restantes e se o jogador queira continuar ou não
            if (remainingTriesMachine != 0 && remainingTriesPlayer != 0) {
                if (machineChoice.equals(winner)) {
                    System.out.println("Vidas restantes do jogador: " + remainingTriesPlayer + " |" + " Gostaria de jogar novamente? (S/N)");
                    System.out.println("Vidas restantes do jogador: " + remainingTriesMachine);
                } else if (playerChoice.equals(winner)) {
                    System.out.println("Vidas restantes da máquina: " + remainingTriesMachine + " |" + " Gostaria de jogar novamente? (S/N)");
                    System.out.println("Vidas restantes do jogador: " + remainingTriesPlayer);
                } else {
                    playerChoice.equals(machineChoice);
                    {
                        System.out.println("Gostaria de jogar novamente? (S/N)");
                    }
                }
            }

            //Serve para evitar entradas inválidas
            choice = scanner.nextLine().toUpperCase();
            while (!choice.equals("S") && !choice.equals("N")) {
                System.out.println("Entrada inválida. Por favor, escolha uma opção válida. Digite (S/N): ");
                choice = scanner.nextLine().toUpperCase();
            }

            if (choice.equals("S")) {
                continue;
            } else {
                choice.equals("N"); {
                    break;
                }
            }

        } while (remainingTriesPlayer != 0 && remainingTriesMachine != 0 );

        scanner.close();
    }

    //Determina o vencedor
    private static String winnerDetermine(String playerChoice, String machineChoice) {
        if (playerChoice.equals(machineChoice)) {
            return "Empate";
        } else if ((playerChoice.equals("PEDRA") && machineChoice.equals("TESOURA")) ||
                (playerChoice.equals("PAPEL") && machineChoice.equals("PEDRA")) ||
                (playerChoice.equals("TESOURA") && machineChoice.equals("PAPEL"))) {
            return playerChoice;
        } else {
            return machineChoice;
        }
    }
}
