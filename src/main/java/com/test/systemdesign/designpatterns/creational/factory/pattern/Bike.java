package com.test.systemdesign.designpatterns.creational.factory.pattern;

public class Bike implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Ride a bike");
    }
}
