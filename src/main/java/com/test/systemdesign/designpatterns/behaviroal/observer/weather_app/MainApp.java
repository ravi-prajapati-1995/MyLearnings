package com.test.systemdesign.designpatterns.behaviroal.observer.weather_app;

public class MainApp {
    public static void main(String[] args) {
        WeatherInfoPublisher weatherInfoPublisher = new WeatherInfoPublisherImpl();

        final var mobileAppWeatherSubscriber = new MobileAppWeatherSubscriber();
        weatherInfoPublisher.add(mobileAppWeatherSubscriber);

        final var emailWeatherSubscriber = new EmailWeatherSubscriber("ravikumar@gmail.com");
        weatherInfoPublisher.add(emailWeatherSubscriber);

        weatherInfoPublisher.update(12);

    }
}
