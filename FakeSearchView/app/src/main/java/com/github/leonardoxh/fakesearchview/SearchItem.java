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
package com.github.leonardoxh.fakesearchview;

/**
 * Interface to make any model searchable by the {@link FakeSearchAdapter}
 *
 * @author Leonardo Rossetto
 */
public interface SearchItem {

  /**
   * This provide to {@link FakeSearchAdapter} the method to
   * check if that model match the constraint search
   * @param constraint used by the adapter to search
   * @return true if the model match false otherwise
   */
  boolean match(CharSequence constraint);

}
