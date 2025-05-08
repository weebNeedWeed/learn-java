package com.giaule.car;

public class Car {
    private final Engine engine;
    private final int seats;
    private final CarType carType;
    private final TripComputer tripComputer;
    private final Transmission transmission;
    private final GPSNavigator gpsNavigator;
    private double fuel = 0;

    public Car(Engine engine, int seats, CarType carType, TripComputer tripComputer, Transmission transmission, GPSNavigator gpsNavigator) {
        this.engine = engine;
        this.seats = seats;
        this.carType = carType;
        this.tripComputer = tripComputer;
        this.transmission = transmission;
        this.gpsNavigator = gpsNavigator;

        if (this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }
    }

    public CarType getCarType() {
        return carType;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }
}
