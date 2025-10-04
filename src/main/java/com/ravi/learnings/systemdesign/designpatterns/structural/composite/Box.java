package com.ravi.learnings.systemdesign.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Box implements PriceAble {
    private final List<PriceAble> items;

    public Box() {
        items = new ArrayList<>();
    }

    public Box(final List<PriceAble> items) {
        this.items = new ArrayList<>(items);
    }

    public void addItem(PriceAble item) {
        this.items.add(item);
    }

    public void addItems(Collection<PriceAble> items) {
        this.items.addAll(items);
    }

    public boolean removeItem(PriceAble item) {
        return items.remove(item);
    }

    @Override
    public double getPrice() {
        return items.stream().map(PriceAble::getPrice).reduce(0.0, Double::sum);
    }
}
