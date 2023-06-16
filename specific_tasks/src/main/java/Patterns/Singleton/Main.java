package Patterns.Singleton;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        double latitude = 40.7128;
        LocalDate date = LocalDate.of(2023, 12, 16);
        String cityName = "NewYork";
        EarthPlanet earthPlanet = EarthPlanet.getInstance(date, latitude, cityName);

        System.out.println(earthPlanet.getSeason());
    }
}
