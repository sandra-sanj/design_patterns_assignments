package factory_method.ascii_ui;

public class Game {
    private static int mapRows = 5;
    private static int mapColumns = 20;

    public static void main(String[] args) {
        //Map map = new CityMap();
        Map map = new WildernessMap();

        createMap(map);
        map.display();
    }

    public static void createMap(Map map) {
        for (int i = 0; i < mapRows; i++) {
            for (int j = 0; j < mapColumns; j++) {
                Tile tile = map.createTile(i, j);
                map.addTile(tile);
            }
        }

    }
}
