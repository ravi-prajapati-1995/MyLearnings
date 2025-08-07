package com.ravi.learnings.systemdesign.designpatterns.behaviroal.strategy.withPattern;

import com.ravi.learnings.systemdesign.designpatterns.behaviroal.strategy.withPattern.drivestrategy.SportsDrive;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportsDrive());
    }
}
