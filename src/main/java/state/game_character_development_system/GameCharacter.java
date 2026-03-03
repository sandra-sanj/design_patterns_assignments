package state.game_character_development_system;

import java.util.Scanner;

public class GameCharacter {
    private static Scanner scanner = new Scanner(System.in);

    private String name;
    private State level;
    private int xp;
    private int hp;

    public GameCharacter(String name) {
        this.name = name;
        this.level = new NoviceState(this);
        this.xp = 0;
        this.hp = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getLevel() {
        return level;
    }

    public void setLevel(State level) {
        this.level = level;
        System.out.printf("\nCongratulations! %s has leveled up to %s level!", this.getName(), this.getLevelName());
    }

    public String getLevelName() {
        return this.getLevel().getStateName();
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void play() {
        do {
            level.action();
            if (this.getHp() < 0) {
                this.gameOverMessageDefeat();
                return;
            }
        } while (!(level instanceof MasterState));

        this.gameOverMessageVictory();
    }

    public void train(int xpGain) {
        String result = String.format(" Gained %d xp\n", xpGain);
        this.printActionMessage("Training", result);

        this.setXp(this.getXp() + xpGain);
    }

    public void meditate(int hpGain) {
        String result = String.format(" Gained %d hp\n", hpGain);
        this.printActionMessage("Meditating", result);

        this.setHp(this.getHp() + hpGain);
    }

    public void fight(int xpGain, int hpLoss) {
        String result = "";
        if (this.getHp() - hpLoss > 0) {
            result = String.format(" Victory! Gained %d xp and lost %d hp\n", xpGain, hpLoss);
        } else {
            result = " Defeat!";
        }
        this.printActionMessage("Fighting", result);

        this.setXp(this.getXp() + xpGain);
        this.setHp(this.getHp() - hpLoss);
    }

    public void printActionMessage(String action, String result) {
        try {
            System.out.print(action);

            for (int i = 1; i <= 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }

            Thread.sleep(500);
            System.out.print(result);
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int readUserChoice(String[] options) {
        // print options
        System.out.println("\nSelect an action:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        // read user input
        return scanner.nextInt();
    }

    public void printStats() {
        System.out.printf("\n%s %s, xp: %d, hp: %d", this.getLevelName(), this.getName(), this.getXp(), this.getHp());
    }

    public void gameOverMessageDefeat() {
        System.out.printf("\n%s %s has been defeated!\nGame Over!", this.getLevelName(), this.getName());
    }

    public void gameOverMessageVictory() {
        System.out.printf("\n%s %s has achieved the highest level!\nGame Over!", this.getLevelName(), this.getName());
    }

}
