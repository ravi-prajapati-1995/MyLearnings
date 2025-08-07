package com.ravi.learnings.systemdesign.designpatterns.behaviroal.strategy.withPattern;

import com.ravi.learnings.systemdesign.designpatterns.behaviroal.strategy.withPattern.drivestrategy.SportsDrive;

public class PassengerVehicle extends Vehicle {
    public PassengerVehicle() {
        super(new SportsDrive());
    }
}
