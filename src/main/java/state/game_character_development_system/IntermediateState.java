package state.game_character_development_system;

public class IntermediateState extends State {

    public IntermediateState(GameCharacter gameCharacter) {
        super(gameCharacter);
        super.setStateName("Intermediate");
    }

    @Override
    void action() {
        this.getGameCharacter().printStats();

        String[] options = {"Train", "Meditate"};
        switch (this.getGameCharacter().readUserChoice(options)) {
            case 1:
                this.getGameCharacter().train(40);
                break;
            case 2:
                this.getGameCharacter().meditate(10);
                break;
        }

        if (this.getGameCharacter().getXp() >= 300)
            this.getGameCharacter().setLevel(new ExpertState(this.getGameCharacter()));
    }
}
