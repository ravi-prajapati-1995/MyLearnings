package com.ravi.learnings.systemdesign.designpatterns.behaviroal.observer.weather_app;

public class MobileAppWeatherSubscriber implements WeatherSubscriber {

    @Override
    public void update(final int temperature) {
        System.out.printf("Display temperature on app %s%n", temperature);
    }
}
