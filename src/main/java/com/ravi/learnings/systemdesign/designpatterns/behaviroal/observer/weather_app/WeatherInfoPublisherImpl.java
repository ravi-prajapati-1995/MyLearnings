package com.ravi.learnings.systemdesign.designpatterns.behaviroal.observer.weather_app;

import java.util.ArrayList;
import java.util.List;

public class WeatherInfoPublisherImpl implements  WeatherInfoPublisher{
    private final List<WeatherSubscriber> subscribers = new ArrayList<>();
    private int temperature;

    @Override
    public void add(final WeatherSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void delete(final WeatherSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        subscribers.forEach(sub -> sub.update(temperature));
    }

    @Override
    public void update(final int temperature) {
        if(temperature != this.temperature) {
            this.temperature = temperature;
            notifySubscribers();
        }

    }
}
