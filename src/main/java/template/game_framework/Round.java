package template.game_framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Round {

    private int id;
    private int correctAnswer;
    private Player winner = null;
    private HashMap<Player, Integer> playerInputs = new HashMap<>();

    public Round(int id) {
        this.id = id;
        this.generateCorrectAnswer();
    }

    private void generateCorrectAnswer() {
        this.correctAnswer = new Random().nextInt(10) + 1;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void calculateWinner() {
        // winner is the one who guessed the closest number
        Player closestPlayer = null;
        Integer closestDifference = null;

        for (Map.Entry<Player, Integer> entry: this.playerInputs.entrySet()) {
            Player player = entry.getKey();
            int input = entry.getValue();

            int difference = input < this.correctAnswer ? this.correctAnswer - input : input - correctAnswer;

            if (closestDifference == null || difference < closestDifference) {
                closestPlayer = player;
                closestDifference = difference;
            }
        }

        this.setWinner(closestPlayer);
    }

    public int getId() {
        return id;
    }

    public HashMap<Player, Integer> getPlayerInputs() {
        return playerInputs;
    }

    public void addPlayerInput(Player player, int input) {
        this.playerInputs.put(player, input);
    }

    @Override
    public String toString() {
        return "Round " + this.getId();
        //return String.format("Round %s winner: %s", this.getId(), this.getWinner());
    }
}
