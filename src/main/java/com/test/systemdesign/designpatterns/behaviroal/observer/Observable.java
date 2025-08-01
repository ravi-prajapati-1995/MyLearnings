package com.test.systemdesign.designpatterns.behaviroal.observer;

public interface Observable<T> {
    void add(Observer<T> observer);
    void delete(Observer<T> observer);
    void notifyObserver();
    void setData(T data);
    T getData();
}
