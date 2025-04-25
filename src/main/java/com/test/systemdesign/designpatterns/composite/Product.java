package com.test.systemdesign.designpatterns.composite;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product implements PriceAble {
    private final String name;
    private final double price;

    @Override
    public double getPrice() {
        return price;
    }
}
