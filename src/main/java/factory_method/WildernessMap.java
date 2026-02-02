package factory_method;

import java.util.Random;

public class WildernessMap extends Map {

    @Override
    public Tile createTile(int row, int column) {
        int randomTileIndex = new Random().nextInt(3);

        Tile tile;
        switch (randomTileIndex) {
            case 0:
                tile = new SwampTile();
                break;
            case 1:
                tile = new WaterTile();
                break;
            default:
                tile = new ForestTile();
        }

        tile.setPosition(row, column);
        return tile;
    }
}
