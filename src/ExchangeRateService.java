package src;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateService {

    private  final String apiKey = Env.get("API_KEY");
    private  final String apiUrl = Env.get("API_URL");

    private  String request(String endpoint) throws Exception{

        String url_str = apiUrl + "/" + apiKey + endpoint;

        // Conexão
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();

        int status = request.getResponseCode();

        if (status != 200){
            throw new RuntimeException("Erro na API: HTTP " + status);
        }

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(request.getInputStream())
        );

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        return response.toString();

    }

    public ExchangeResponse convert(String from, String to, double amount) throws Exception {
        String endpoint = String.format("/pair/%s/%s/%s", from, to, amount);
        String json = request(endpoint);

        Gson gson = new Gson();
        ExchangeResponse response = gson.fromJson(json, ExchangeResponse.class);

        return  response;
    }

}
