package com.ravi.learnings.systemdesign.designpatterns.behaviroal.strategy.withPattern;

import com.ravi.learnings.systemdesign.designpatterns.behaviroal.strategy.withPattern.drivestrategy.DriveStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Here we made a relationship vehicle has Drive strategy
 * */
@AllArgsConstructor
@Getter
public class Vehicle {
    private DriveStrategy driveStrategy;

    void drive() {
        driveStrategy.drive();
    }
}
