package com.ravi.learnings.systemdesign.designpatterns.behaviroal.observer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ObserverImpl implements Observer<Integer> {
    private Observable<Integer> observable;

    @Override
    public void update() {
        final var data = observable.getData();
    }
}
