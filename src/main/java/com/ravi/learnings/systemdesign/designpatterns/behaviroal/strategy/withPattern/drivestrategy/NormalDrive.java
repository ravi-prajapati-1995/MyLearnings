package com.ravi.learnings.systemdesign.designpatterns.behaviroal.strategy.withPattern.drivestrategy;

public class NormalDrive implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("this is normal driving");
    }
}
