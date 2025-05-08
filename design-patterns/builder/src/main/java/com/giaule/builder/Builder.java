package com.giaule.builder;

import com.giaule.car.*;

public interface Builder {
    void setEngine(Engine engine);
    void setSeats(int seats);
    void setCarType(CarType carType);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
    void setTransmission(Transmission transmission);
}
