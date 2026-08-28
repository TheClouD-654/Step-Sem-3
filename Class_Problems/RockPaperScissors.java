import java.util.Scanner;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if (playerMove.equals("Rock") && computerMove.equals("Scissors")) return "Player Wins";
        if (playerMove.equals("Paper") && computerMove.equals("Rock")) return "Player Wins";
        if (playerMove.equals("Scissors") && computerMove.equals("Paper")) return "Player Wins";
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] moves = { "Rock", "Paper", "Scissors" };
        int rounds = 5;
        String[][] results = new String[rounds][3];
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) + " - Rock, Paper, or Scissors: ");
            String playerMove = scanner.nextLine();
            playerMove = playerMove.substring(0, 1).toUpperCase() + playerMove.substring(1).toLowerCase();
            String computerMove = moves[(int) (Math.random() * 3)];
            String result = playRound(playerMove, computerMove);
            results[i] = new String[] { playerMove, computerMove, result };
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        System.out.println("\nRound\tPlayer\tComputer\tResult");
        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + "\t" + results[i][0] + "\t" + results[i][1] + "\t" + results[i][2]);
        }
        double winPercentage = wins * 100.0 / rounds;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");
        scanner.close();
    }
}
