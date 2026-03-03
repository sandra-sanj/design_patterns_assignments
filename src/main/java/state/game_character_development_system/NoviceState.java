package state.game_character_development_system;

public class NoviceState extends State {

    public NoviceState(GameCharacter gameCharacter) {
        super(gameCharacter);
        super.setStateName("Novice");
    }

    @Override
    void action() {
        this.getGameCharacter().printStats();

        String[] options = {"Train"};
        switch (this.getGameCharacter().readUserChoice(options)) {
            case 1:
                this.getGameCharacter().train(25);
                break;
        }

        if (this.getGameCharacter().getXp() >= 100)
            this.getGameCharacter().setLevel(new IntermediateState(this.getGameCharacter()));
    }
}
