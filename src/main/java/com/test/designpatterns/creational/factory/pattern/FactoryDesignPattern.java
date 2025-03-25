package com.test.designpatterns.creational.factory.pattern;

public class FactoryDesignPattern {
    public static void main(String[] args) {
        final var car = VehicleFactory.getVehicle("car");
        car.drive();

        final var bike = VehicleFactory.getVehicle("bike");
        bike.drive();
    }
}


