package facade.api_facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class ApiFacade {
    public static String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {
        String jsonResult = getJsonFromApi(urlString);
        return extractAttributeFromJson(jsonResult, attributeName);
    }

    private static String getJsonFromApi(String apiUrl) throws IOException {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            if (con.getResponseCode() != 200) {
                throw new IOException("Invalid HTTP response code (" + con.getResponseCode() + ") for " + apiUrl);
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                return content.toString();
            } finally {
                con.disconnect();
            }

        } catch (UnknownHostException e) {
            throw new IOException("Invalid URL " + apiUrl);
        }
    }

    private static String extractAttributeFromJson(String json, String attributeName) throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            return jsonObject.get(attributeName).toString();
        } catch (ParseException e) {
            throw new IllegalArgumentException("ParseException: " + e.getMessage());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("No attribute '" + attributeName + "' in response.");
        }
    }
}
