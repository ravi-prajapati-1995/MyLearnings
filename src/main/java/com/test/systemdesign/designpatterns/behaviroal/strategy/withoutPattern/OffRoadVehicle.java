package com.test.systemdesign.designpatterns.behaviroal.strategy.withoutPattern;

/**
 * This class will have same drive method as Sports Vehicle, code duplication is there
 * */
public class OffRoadVehicle extends Vehicle{

    @Override
    public void drive() {
        System.out.println("This is having high performance Engine");
    }
}
