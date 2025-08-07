package com.ravi.learnings.systemdesign.designpatterns.behaviroal.strategy.withPattern.drivestrategy;

public class SportsDrive implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Is is doing high performance driving, as sports drive");
    }
}
