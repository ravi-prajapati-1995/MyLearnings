package com.test.systemdesign.designpatterns.behaviroal.observer;

public interface Observable<T> {
    void add(Observer observer);
    void delete(Observer observer);
    void notifyObserver();
    void setData(T data);
    T getData();
}
