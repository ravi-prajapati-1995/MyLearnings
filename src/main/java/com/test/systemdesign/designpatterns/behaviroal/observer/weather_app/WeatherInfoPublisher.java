package com.test.systemdesign.designpatterns.behaviroal.observer.weather_app;

public interface WeatherInfoPublisher {
    void add(WeatherSubscriber subscriber);
    void delete(WeatherSubscriber subscriber);
    void notifySubscribers();
    void update(int temperature);
}
