package com.projet_API.tp5.controler;

import com.projet_API.tp5.request.*;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class MeteoController {

    @PostMapping (path = "/meteo")
            //consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String showAddresses (@RequestParam(value = "address") String meteoAdresse, Model model){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();

        System.out.println(meteoAdresse);
        double[] data = getAddressResult(restTemplate, model, meteoAdresse);
        getMeteoResult(restTemplate, model, data[1], data[0]);
        return "meteo";
    }

    private double[] getAddressResult(RestTemplate restTemplate, Model model, String meteoAdresse) {
        String uri = "https://api-adresse.data.gouv.fr/search/?limit=1&q=" + meteoAdresse.replace(" ", "+");
        System.out.println(uri);
        AddressQueryResult result = restTemplate.getForObject(uri, AddressQueryResult.class);

        String nom = result.getFeatures()[0].getProperties().getName();
        String ville = result.getFeatures()[0].getProperties().getCity() + ", " +result.getFeatures()[0].getProperties().getContext();
        double longitude = result.getFeatures()[0].getGeometry().getCoordinates()[0];
        double latitude = result.getFeatures()[0].getGeometry().getCoordinates()[1];

        // Affichage des informations dans le fichier html
        model.addAttribute("name", nom);
        model.addAttribute("city", ville);

        model.addAttribute("lon", longitude);
        model.addAttribute("lat", latitude);

        return new double[]{longitude, latitude};
    }

    private void getMeteoResult(RestTemplate restTemplate, Model model, double latitude, double longitude) {
        // Préparation de la requête
        String uri = "https://api.meteo-concept.com/api/forecast/daily?" +
                "token=dfc7933b44562fa04f04b0fa8a47485dffaa91309b6453e5d2171a4aa633a5ed&" +
                "latlng="+ latitude +","+ longitude;

        // Résultat de la requête
        MeteoQueryResult result = restTemplate.getForObject(uri, MeteoQueryResult.class);

        // Traitement des informations
        int probaPluie = result.getForecast()[0].getProbarain();
        int tmin = result.getForecast()[0].getTmin();
        int tmax = result.getForecast()[0].getTmax();
        int weather = result.getForecast()[0].getWeather();

        // Affichage des informations dans le fichier html
        model.addAttribute("probarain", probaPluie);
        model.addAttribute("tmin", tmin);
        model.addAttribute("tmax", tmax);
        model.addAttribute("weather", weather);
    }

}