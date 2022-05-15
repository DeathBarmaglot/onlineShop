package com.store.model.currency;

import com.store.country.Country;
import com.store.country.CountryService;
import lombok.AllArgsConstructor;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;

@AllArgsConstructor
public class CurrencyConvector implements CountryService {

    private ExchangeResolver exchangeResolver;

    @Override
    public double exchange(double price) {
        return exchangeResolver.getСurrency() * price;
    }

    @Override
    public Optional<Country> getByName(String username) {
        return Optional.empty();
    }

    private static void exchangeRateGETRequest(String fromCode, String toCode, double amount) throws IOException {
        DecimalFormat f = new DecimalFormat("00.00");
        String GET_URL = "https://api.exchangeratesapi.io/latest?base=" + toCode + "&symbols=" + fromCode;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            bufferedReader.close();
            JSONObject obj = new JSONObject(response.toString());
            Double exchangeRate = obj.getJSONObject("rates").getDouble(fromCode);
            System.out.println(f.format(amount) + fromCode + " = " + f.format(amount/exchangeRate) + toCode);
        }
        else {
            System.out.println("Get request failed!");
        }
    }
}
