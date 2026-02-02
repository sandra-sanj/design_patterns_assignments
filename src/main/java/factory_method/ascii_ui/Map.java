package factory_method.ascii_ui;

import java.util.ArrayList;

public abstract class Map {
    private ArrayList<Tile> tiles = new ArrayList<>();

    public void addTile(Tile tile) {
        this.tiles.add(tile);
    }

    public ArrayList<Tile> getTiles() {
        return this.tiles;
    }

    public abstract Tile createTile(int row, int column);

    public void display() {
        int lastTileRow = 0;

        for (Tile tile : this.getTiles()) {
            if (tile.getRow() > lastTileRow) {
                System.out.println();
                lastTileRow = tile.getRow();
            }
            System.out.print(tile.getCharacter());
        }
    }
}
