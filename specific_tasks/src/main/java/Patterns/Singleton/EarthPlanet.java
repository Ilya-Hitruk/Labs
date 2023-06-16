package Patterns.Singleton;

import java.time.LocalDate;

public class EarthPlanet {
    private static EarthPlanet earthPlanet;
    public LocalDate localDate;
    public double latitude;
    public String nameOfTheCity;


    private EarthPlanet(LocalDate localDate, double latitude, String nameOfTheCity){
        this.localDate = localDate;
        this.latitude = latitude;
        this.nameOfTheCity = nameOfTheCity;
    }

    public static EarthPlanet getInstance(LocalDate localDate, double attitude, String nameOfTheCity) {
        synchronized (EarthPlanet.class) {
            if (earthPlanet == null) {
                earthPlanet = new EarthPlanet(localDate, attitude, nameOfTheCity);
            }
        }
        return earthPlanet;
    }

    public String getSeason() {
        int month = localDate.getMonthValue();
        String season;

        if (month >= 3 && month <= 5) {
            season = "Spring";
        } else if (month >= 6 && month <= 8) {
            season = "Summer";
        } else if (month >= 9 && month <= 11) {
            season = "Autumn";
        } else {
            // Для зимы проверяем широту
            if (latitude >= 0) {
                season = "Winter (North side)";
            } else {
                season = "Winter (South side)";
            }
        }

        return "This day is the " + season + " in " + nameOfTheCity;
    }
}
