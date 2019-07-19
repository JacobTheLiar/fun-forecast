package pl.jacob_the_liar.forecast.core;

import java.net.URLEncoder;
import java.util.Locale;

public class UrlGeo implements IUrl{

    private static String BASE_URL_PATTERN = "https://geocode.xyz/%s?json=1";

    private String name;

    public UrlGeo(String name) {
        this.name = name;
    }


    @Override
    public String getUrl() {
        String query;
        try {
            String enc = URLEncoder.encode(name, "UTF-8");
            query = String.format(Locale.US, BASE_URL_PATTERN, enc);
        } catch (Exception e) {
            query = String.format(Locale.US, BASE_URL_PATTERN, name);
        }
        return query;
    }
}
