package com.test.systemdesign.designpatterns.behaviroal.observer.weather_app;

public class EmailWeatherSubscriber implements WeatherSubscriber{
    private final String email;

    public EmailWeatherSubscriber(final String email) {
        this.email = email;
    }

    @Override
    public void update(final int temperature) {
        System.out.printf("Sending email to : %s, with update Temprature: %s%n", email, temperature);
    }
}
