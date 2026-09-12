import java.util.Scanner;
import java.util.Random;
class RockPaperScissors {
    String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RockPaperScissors obj = new RockPaperScissors();
        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0;
        int losses = 0;
        int draws = 0;
        System.out.println("Enter number of rounds:");
        int n = sc.nextInt();
        System.out.println();
        System.out.println("Round\tPlayer\tComputer\tResult");
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter your move: ");
            String playerMove = sc.next();
            Random random = new Random();
            String computerMove = moves[random.nextInt(3)];
            String result = obj.playRound(playerMove, computerMove);
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            System.out.println(i + "\t" + playerMove + "\t" + computerMove + "\t\t" + result);
        }
        double winPercentage = (double) wins / n * 100;
        System.out.println();
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");
    }
}
