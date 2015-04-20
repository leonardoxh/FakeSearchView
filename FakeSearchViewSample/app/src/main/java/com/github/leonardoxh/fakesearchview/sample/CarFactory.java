package com.github.leonardoxh.fakesearchview.sample;

import java.util.Arrays;
import java.util.List;

final class CarFactory {

  static List<Car> getCars() {
    return Arrays.asList(
        new Car("Ferrari"),
        new Car("Lamborghini"),
        new Car("Bugati"),
        new Car("Wolksvagen"),
        new Car("Fiat"),
        new Car("Renault"),
        new Car("Mercedes")
    );
  }

}
