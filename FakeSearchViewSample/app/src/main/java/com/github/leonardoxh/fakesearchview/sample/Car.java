/*
 * Copyright 2015 Leonardo Rossetto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
