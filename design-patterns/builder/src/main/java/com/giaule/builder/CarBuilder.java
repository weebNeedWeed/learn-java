package com.giaule.builder;

import com.giaule.car.*;

public class CarBuilder implements Builder{
    private Engine engine;
    private int seats;
    private CarType carType;
    private TripComputer tripComputer;
    private Transmission transmission;
    private GPSNavigator gpsNavigator;

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Car getResults() {
        return new Car(engine, seats, carType, tripComputer, transmission, gpsNavigator);
    }
}
