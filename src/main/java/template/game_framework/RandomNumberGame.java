package template.game_framework;

import java.util.*;

public class RandomNumberGame extends Game {

    private final List<Player> playerList = new ArrayList<>();
    private final List<Round> roundList = new ArrayList<>();

    private final int rounds = 5;
    private Player winner;

    public RandomNumberGame(int numberOfPlayers) {

        super.play(numberOfPlayers);
    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.printf("Welcome to Random Number Guessing Game!\n" +
                "A number is randomized from 1 to 10, the player who guesses the closest wins the round.\n" +
                "The player with the most round wins after %d rounds wins the game.\n", this.rounds);

        for (int i = 1; i <= numberOfPlayers; i++)
            playerList.add(new Player("Player " + i));
        this.startNewRound();
    }

    @Override
    public boolean endOfGame() {
        if (roundList.size() >= rounds && getCurrentRound().getWinner() != null) {
            this.calculateWinner();
            // game end
            return true;
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        Round currentRound = getCurrentRound();
        Player playerPlaying = this.playerList.get(player);

        System.out.print(playerPlaying + ", enter guess: ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        int input = scanner.nextInt();

        currentRound.addPlayerInput(playerPlaying, input);

        // try to end round
        if (currentRound.getPlayerInputs().size() >= playerList.size()) {
            currentRound.calculateWinner();  // end the round

            System.out.printf("Correct answer was %d. Winner is %s\n", currentRound.getCorrectAnswer(), currentRound.getWinner());

            if (roundList.size() < rounds) {
                this.startNewRound();
            }
        }
    }

    @Override
    public void displayWinner() {
        System.out.printf("%s has won the game!\nGame Over!", this.getWinner().getName());
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void calculateWinner() {
        // get winner: player with most round wins

        // go through all rounds and save win counts per player
        HashMap<Player, Integer> winsPerPlayers = new HashMap<>();

        for (Round round : roundList) {
            winsPerPlayers.merge(round.getWinner(), 1, Integer::sum);
        }

        // get player with most wins
        Player winner = Collections.max(winsPerPlayers.entrySet(), Map.Entry.comparingByValue()).getKey();
        this.setWinner(winner);
    }

    public void startNewRound() {
        int lastRoundId = this.roundList.isEmpty() ? 0 : this.getCurrentRound().getId();
        this.roundList.add(new Round(lastRoundId + 1));

        System.out.println("\n" + this.roundList.getLast());
    }

    public Round getCurrentRound() {
        return this.roundList.getLast();
    }
}
