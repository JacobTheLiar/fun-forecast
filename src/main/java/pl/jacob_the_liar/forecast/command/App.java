package pl.jacob_the_liar.forecast.command;

import pl.jacob_the_liar.forecast.core.ForecastManager;
import pl.jacob_the_liar.forecast.core.IUrl;
import pl.jacob_the_liar.forecast.core.UrlCivil;
import pl.jacob_the_liar.forecast.seven_timer.civil.SevenTimerForecast;

public class App
{



    public static void main( String[] args )
    {
        System.out.println( "Fun - Forecast" );

//        IUrl url = new UrlCivil(17.3, 52.2);
        IUrl url = new UrlCivil(15.9, 50.8);

        ForecastManager forecastManager = new ForecastManager();

        SevenTimerForecast forecast = forecastManager.getCivilForecast(url);

        Printer printer = new Printer(forecast);
        printer.print();



    }
}
