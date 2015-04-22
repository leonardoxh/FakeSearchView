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

import android.support.v4.view.MenuItemCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

import com.github.leonardoxh.fakesearchview.FakeSearchView;

public class MainActivity extends AppCompatActivity implements FakeSearchView.OnSearchListener {

  @InjectView(R.id.car_list) protected ListView cars;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    cars.setAdapter(new CarAdapter(this, CarFactory.getCars()));
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    initSearchView(menu);
    return true;
  }

  private void initSearchView(Menu menu) {
    MenuItem item = menu.findItem(R.id.search_cars);
    FakeSearchView fakeSearchView = (FakeSearchView) MenuItemCompat.getActionView(item);
    fakeSearchView.setOnSearchListener(this);
  }

  @Override public void onSearch(CharSequence constraint) {
    ((CarAdapter)cars.getAdapter()).getFilter().filter(constraint);
  }

  @Override public void onSearchHint(CharSequence constraint) {
    ((CarAdapter)cars.getAdapter()).getFilter().filter(constraint);
  }

}
