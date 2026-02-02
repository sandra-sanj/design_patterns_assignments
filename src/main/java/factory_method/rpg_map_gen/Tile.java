package factory_method.rpg_map_gen;

public abstract class Tile {
    private int row;
    private int column;

    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public abstract String getCharacter();
    public abstract String getType();
    public abstract void action();
}
