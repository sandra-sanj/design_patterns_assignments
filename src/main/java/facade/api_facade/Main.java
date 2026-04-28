package facade.api_facade;

public class Main {
    public static void main(String[] args) {

        String[][] apiCalls = {
                {"https://api.chucknorris.io/jokes/random", "value"},
                {"https://api.fxratesapi.com/latest", "rates"},
                {"https://meowfacts.herokuapp.com/", "data"}, // source: https://github.com/wh-iterabb-it/meowfacts
                {"https://api.chucknorris.io/jokes/rando", "value"}, // exception - address
                {"https://apii.chucknorris.io/jokes/random", "value"}, // exception - address
                {"https://api.chucknorris.io/jokes/random", ""}, // exception - attribute
                {"https://meowfacts.herokuapp.com/", "datas"}, // exception - attribute
                {"https://api.chucknorris.io/jokes/random", "value"},
        };

        for (String[] apiCall : apiCalls) {
            try {
                System.out.println();
                String response = ApiFacade.getAttributeValueFromJson(apiCall[0], apiCall[1]);
                System.out.println(response);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
