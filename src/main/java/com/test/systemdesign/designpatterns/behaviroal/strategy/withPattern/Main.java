package com.test.systemdesign.designpatterns.behaviroal.strategy.withPattern;

/**
 Here we created new interface/strategy DriveStrategy, Child object has full control that whichever strategy they want
 they can use
* */
class Main {
    public static void main(String[] args) {
        final var passengerVehicle = new PassengerVehicle();
        final var sportsVehicle = new SportsVehicle();
        final var offRoadVehicle = new OffRoadVehicle();

        passengerVehicle.drive();
        sportsVehicle.drive();
        offRoadVehicle.drive();
    }
}