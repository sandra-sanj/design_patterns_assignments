package state.game_character_development_system;

public abstract class State {
    private String stateName;
    private GameCharacter gameCharacter;

    public State(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public GameCharacter getGameCharacter() {
        return this.gameCharacter;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    abstract void action();

    /*abstract void train();
    abstract void meditate();
    abstract void fight();*/
}
