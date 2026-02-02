package factory_method.rpg_map_gen;

public class WaterTile extends Tile {

    @Override
    public String getCharacter() {
        return "W";
    }

    @Override
    public String getType() {
        return "water";
    }

    @Override
    public void action() {

    }
}
