package com.test.systemdesign.designpatterns.behaviroal.observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable<Integer>{
    private int data;
    private static final List<Observer<Integer>> observers = new ArrayList<>();
    @Override
    public void add(final Observer<Integer> observer) {
        observers.add(observer);
    }

    @Override
    public void delete(final Observer<Integer> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(Observer::update);
    }

    @Override
    public void setData(final Integer data) {
        this.data = data;
        notifyObserver();
    }

    @Override
    public Integer getData() {
        return data;
    }
}
