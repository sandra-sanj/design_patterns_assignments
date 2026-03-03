package state.game_character_development_system;

public class MasterState extends State {

    public MasterState(GameCharacter gameCharacter) {
        super(gameCharacter);
        super.setStateName("Master");
    }

    @Override
    void action() {
        // end game
    }
}
