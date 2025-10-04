package com.ravi.learnings.systemdesign.designpatterns.creational.factory.pattern;

public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if ("car".equals(type)) {
            return new Car();
        } else if ("bike".equals(type)) {
            return new Bike();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}
