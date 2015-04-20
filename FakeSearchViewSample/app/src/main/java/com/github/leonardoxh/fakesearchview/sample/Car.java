package com.github.leonardoxh.fakesearchview.sample;

import com.github.leonardoxh.fakesearchview.SearchItem;
import java.util.Locale;

public class Car implements SearchItem {

  private String model;

  public Car(String model) {
    this.model = model;
  }

  public String getModel() {
    return model;
  }

  @Override public boolean match(CharSequence constraint) {
    return model.toLowerCase(Locale.US)
        .startsWith(constraint.toString().toLowerCase(Locale.US));
  }

}
