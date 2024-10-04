import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConversorDeMonedas {
    private String API_KEY;
    private final String[] MONEDAS = {"ARS", "BOB", "BRL"};
    private final double[] tasasDeConversion;

    public ConversorDeMonedas() throws IOException, InterruptedException {
        cargarConfiguracion();
        this.tasasDeConversion = obtenerTasasDeCambio();
    }

    private void cargarConfiguracion() throws IOException {
        Properties propiedades = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            propiedades.load(input);
            API_KEY = propiedades.getProperty("api.key"); // Obtener la API key
        }
    }

    private double[] obtenerTasasDeCambio() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers. ofString());

        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.body(),JsonObject.class);
        JsonObject constantes= jsonResponse.getAsJsonObject("conversion_rates");

        return new double[] {
                constantes.get(MONEDAS[0]).getAsDouble(),
                constantes.get(MONEDAS[1]).getAsDouble(),
                constantes.get(MONEDAS[2]).getAsDouble(),
        };
    }

    public double convertirDolarAMoneda(double cantidadUSD, int tasaIndex) {
        return cantidadUSD * tasasDeConversion[tasaIndex];
    }

    public double convertirMonedaADolar(double cantidad, int tasaIndex){
        return cantidad / tasasDeConversion[tasaIndex];
    }

    public String[] getMonedas() {
        return MONEDAS;
    }

    public int getCantidadMonedas() {
        return MONEDAS.length;
    }
}
