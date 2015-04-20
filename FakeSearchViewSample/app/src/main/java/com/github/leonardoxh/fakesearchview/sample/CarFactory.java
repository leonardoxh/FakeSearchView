package com.github.leonardoxh.fakesearchview.sample;

import java.util.ArrayList;
import java.util.List;

final class CarFactory {

  static List<Car> getCars() {
    List<Car> cars = new ArrayList<>();
    cars.add(new Car("Ferrari"));
    cars.add(new Car("Lamborghini"));
    cars.add(new Car("Bugati"));
    cars.add(new Car("Wolksvagen"));
    cars.add(new Car("Fiat"));
    cars.add(new Car("Renault"));
    cars.add(new Car("Mercedes"));
    return cars;
  }

}
