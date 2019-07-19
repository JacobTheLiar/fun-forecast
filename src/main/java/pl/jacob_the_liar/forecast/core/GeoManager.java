package pl.jacob_the_liar.forecast.core;

import com.google.gson.Gson;
import pl.jacob_the_liar.forecast.geocode.name.GeocodeFromName;
import pl.jacob_the_liar.forecast.internet.InternetProvider;

public class GeoManager{


    public IGeoCoordinates getCoordinates(IUrl url){
        String response;


        try{
            response = InternetProvider.getResponse(url.getUrl());
            Gson gson= new Gson();
            GeocodeFromName result = gson.fromJson(response, GeocodeFromName.class);
            return new IGeoCoordinates() {
                @Override
                public double getLongitude() {
                    return Double.parseDouble(result.getLongt());
                }

                @Override
                public double getLatitude() {
                    return Double.parseDouble(result.getLatt());
                }
            };
        } catch (Exception e){
            System.out.println("ERROR!!!");
            e.printStackTrace();
        }
        return null;
    }

}
