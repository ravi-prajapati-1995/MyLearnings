package com.test.systemdesign.designpatterns.behaviroal.strategy.withPattern;

import com.test.systemdesign.designpatterns.behaviroal.strategy.withPattern.drivestrategy.DriveStrategy;
import com.test.systemdesign.designpatterns.behaviroal.strategy.withPattern.drivestrategy.SportsDrive;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportsDrive());
    }
}
