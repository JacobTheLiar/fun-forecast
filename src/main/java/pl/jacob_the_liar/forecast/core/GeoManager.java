package pl.jacob_the_liar.forecast.core;

import com.google.gson.Gson;
import pl.jacob_the_liar.forecast.osm.GeocodeFromName;
import pl.jacob_the_liar.forecast.internet.InternetProvider;

public class GeoManager{


    public IGeoCoordinates getCoordinates(IUrl url){
        String response;


        try{
            response = InternetProvider.getResponse(url.getUrl());
            Gson gson= new Gson();
            GeocodeFromName[] result = gson.fromJson(response, GeocodeFromName[].class);
            System.out.println(result[0].getType()+": "+ result[0].getDisplayName()+" @ "+result[0].getLat()+","+result[0].getLon());
            
            return new IGeoCoordinates() {
                @Override
                public double getLongitude() {
                    return Double.parseDouble(result[0].getLon());
                }

                @Override
                public double getLatitude() {
                    return Double.parseDouble(result[0].getLat());
                }
            };
        } catch (Exception e){
            System.out.println("ERROR!!!");
            e.printStackTrace();
        }
        return null;
    }

}
