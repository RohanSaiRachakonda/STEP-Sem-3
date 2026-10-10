import java.util.Random;
public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
    public static void main(String[] args) {
        String[] options = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"}; // Predefined list for a live demo[cite: 2]
        Random rand = new Random();   
        int wins = 0, losses = 0, draws = 0;
        int n = 5;
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < n; i++) {
            String pMove = playerMoves[i];
            String cMove = options[rand.nextInt(3)]; // Generate the computer's move randomly[cite: 2]
            String result = playRound(pMove, cMove);
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            System.out.printf("Round %d | %s | %s | %s%n", i + 1, pMove, cMove, result);
        }
        double winPercentage = (wins * 100.0) / n;
        System.out.printf("\nFinal Summary\nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }
}