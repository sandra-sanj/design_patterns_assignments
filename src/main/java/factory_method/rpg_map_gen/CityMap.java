package factory_method.rpg_map_gen;

import java.util.Random;

public class CityMap extends Map {

    @Override
    public Tile createTile(int row, int column) {
        int randomTileIndex = new Random().nextInt(3);

        Tile tile;
        switch (randomTileIndex) {
            case 0:
                tile = new RoadTile();
                break;
            case 1:
                tile = new ForestTile();
                break;
            default:
                tile = new BuildingTile();
        }

        tile.setPosition(row, column);
        return tile;
    }
}
