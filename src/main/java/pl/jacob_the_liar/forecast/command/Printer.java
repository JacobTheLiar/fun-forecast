package pl.jacob_the_liar.forecast.command;

import pl.jacob_the_liar.forecast.seven_timer.civil.Dataseries;
import pl.jacob_the_liar.forecast.seven_timer.civil.SevenTimerForecast;

import static pl.jacob_the_liar.forecast.utils.MyUtils.assigned;

public class Printer {

    private static final String DATA_PATTERN =
            "time point: %3d; cloud cover: %1d; lift index: %3d; precipitation: %4s(%1d); temp: %2d; humidity: %4s; wind: %2d(%2s); icon: %s";

    private SevenTimerForecast forecast;

    public Printer(SevenTimerForecast forecast) {
        this.forecast = forecast;
    }

    public void print() {
        if (assigned(forecast)) {
            System.out.print("init: ");

            System.out.println(forecast.getInit());

            for (Dataseries item : forecast.getDataseries()) {
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
        } else {
            System.out.println("forecast is not initialized");
        }
    }

}
