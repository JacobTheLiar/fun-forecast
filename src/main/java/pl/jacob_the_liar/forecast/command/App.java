package pl.jacob_the_liar.forecast.command;

import pl.jacob_the_liar.forecast.core.ForecastManager;
import pl.jacob_the_liar.forecast.core.IUrl;
import pl.jacob_the_liar.forecast.core.UrlCivil;
import pl.jacob_the_liar.forecast.seven_timer.civil.SevenTimerForecast;
import pl.jacob_the_liar.forecast.core.IGeoCoordinates;
import pl.jacob_the_liar.forecast.core.GeoCoordinates;

import static pl.jacob_the_liar.forecast.utils.Input.getString;


public class App
{

    public static void main( String[] args )
    {
        System.out.println( "Fun - Forecast" );


        System.out.println("input location name or coordinates (eg. 52.2, 17.3) for view weather forecast");

        String enteredText = getString();

        IGeoCoordinates stg = new GeoCoordinates(enteredText);

        System.out.println("searching forecast for");
        System.out.println(stg.info());

        IUrl url = new UrlCivil(stg.getLongitude(), stg.getLatitude());

        ForecastManager forecastManager = new ForecastManager();

        SevenTimerForecast forecast = forecastManager.getCivilForecast(url);

        Printer printer = new Printer(forecast);
        printer.print();



    }
}
