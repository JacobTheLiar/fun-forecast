package pl.jacob_the_liar.forecast.core;

import com.google.gson.Gson;
import pl.jacob_the_liar.forecast.internet.InternetProvider;
import pl.jacob_the_liar.forecast.seven_timer.civil.SevenTimerForecast;

public class ForecastManager {


    public SevenTimerForecast getCivilForecast(IUrl url){
        String response = "";

        try{
            response = InternetProvider.getResponse(url.getUrl());
            Gson gson= new Gson();
            SevenTimerForecast result = gson.fromJson(response, SevenTimerForecast.class);
            return result;
        } catch (Exception e){
            System.out.println("ERROR!!!");
            e.printStackTrace();
        }
        return null;
    }


}
