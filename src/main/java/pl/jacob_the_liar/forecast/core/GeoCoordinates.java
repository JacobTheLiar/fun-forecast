package pl.jacob_the_liar.forecast.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeoCoordinates implements IGeoCoordinates {


    private double longitude = 15.9;
    private double latitude = 50.8;
    private String geoText;

    public GeoCoordinates(String geoText) {
        this.geoText = geoText.trim();

        if (isGeoCoords())
            parseGeoCords();
        else
            parseFromLocation();

    }

    private void parseFromLocation() {
        IUrl url = new UrlGeo(geoText);
        GeoManager manager = new GeoManager();

        IGeoCoordinates coord = manager.getCoordinates(url);

        latitude = coord.getLatitude();
        longitude = coord.getLongitude();

    }

    private void parseGeoCords() {
        String[] parts = geoText.split(",");

        latitude = Double.parseDouble(parts[0].trim());
        longitude = Double.parseDouble(parts[1].trim());
    }

    private boolean isGeoCoords() {
        //https://www.regexplanet.com/advanced/java/index.html

        boolean result = false;
        String stringPattern = "^(-?)(\\d{1}|\\d{2}|\\d{3})(\\.)(\\d{1}|\\d{2}|\\d{3}|\\d{4}|\\d{5}|\\d{6}|\\d{7}|\\d{8}|\\d{9})(\\,)(\\ ?)(-?)(\\d{1}|\\d{2}|\\d{3})(\\.)(\\d{1}|\\d{2}|\\d{3}|\\d{4}|\\d{5}|\\d{6}|\\d{7}|\\d{8}|\\d{9})";

        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(geoText);

        result = matcher.matches();

        return result;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }

    @Override
    public double getLatitude() {
        return latitude;
    }
}
