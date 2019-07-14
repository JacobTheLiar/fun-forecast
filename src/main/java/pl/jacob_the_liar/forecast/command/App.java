package pl.jacob_the_liar.forecast.command;

import pl.jacob_the_liar.forecast.core.ForecastManager;
import pl.jacob_the_liar.forecast.core.IUrl;
import pl.jacob_the_liar.forecast.core.UrlCivil;
import pl.jacob_the_liar.forecast.seven_timer.civil.Dataseries;
import pl.jacob_the_liar.forecast.seven_timer.civil.SevenTimerForecast;

/**
 * Hello world!
 *
 */
public class App
{

    private static final String DATA_PATTERN =
        "time point: %3d; cloud cover: %1d; lift index: %4d; precipitation: %4s(%1d); temp: %2d; humidity: %4s; wind: %2d(%2s); icon: %s";

    public static void main( String[] args )
    {
        System.out.println( "Fun - Forecast" );

        IUrl url = new UrlCivil(17.3, 52.2);

        ForecastManager forecastManager = new ForecastManager();

        SevenTimerForecast forecast = forecastManager.getCivilForecast(url);


        System.out.print("init: ");
        System.out.println(forecast.getInit());


        for (Dataseries item : forecast.getDataseries()){
            System.out.println(String.format(DATA_PATTERN,
                    item.getTimepoint(),
                    item.getCloudcover(),
                    item.getLiftedIndex(),
                    item.getPrecType(),
                    item.getPrecAmount(),
                    item.getTemp2m(),
                    item.getRh2m(),
                    item.getWind10m().getSpeed(),
                    item.getWind10m().getDirection(),
                    item.getWeather()


                    ));
        }

    }
}
