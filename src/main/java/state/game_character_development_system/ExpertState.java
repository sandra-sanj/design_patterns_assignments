package state.game_character_development_system;

public class ExpertState extends State {

    public ExpertState(GameCharacter gameCharacter) {
        super(gameCharacter);
        super.setStateName("Expert");
    }

    @Override
    void action() {
        this.getGameCharacter().printStats();

        String[] options = {"Train", "Meditate", "Fight"};
        switch (this.getGameCharacter().readUserChoice(options)) {
            case 1:
                this.getGameCharacter().train(50);
                break;
            case 2:
                this.getGameCharacter().meditate(15);
                break;
            case 3:
                this.getGameCharacter().fight(75, 30);
                break;
        }

        if (this.getGameCharacter().getXp() >= 600)
            this.getGameCharacter().setLevel(new MasterState(this.getGameCharacter()));
    }
}
