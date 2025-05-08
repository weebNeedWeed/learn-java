package com.giaule;

import com.giaule.builder.CarBuilder;
import com.giaule.builder.CarManualBuilder;
import com.giaule.car.Car;
import com.giaule.car.Manual;

public class App {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder();
        director.constructCityCar(carBuilder);
        Car car = carBuilder.getResults();
        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.constructCityCar(carManualBuilder);
        Manual carManual = carManualBuilder.getResults();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
