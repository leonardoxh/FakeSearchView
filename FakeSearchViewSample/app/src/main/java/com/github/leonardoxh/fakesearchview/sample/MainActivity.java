package com.github.leonardoxh.fakesearchview.sample;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

import com.github.leonardoxh.fakesearchview.FakeSearchView;

public class MainActivity extends ActionBarActivity implements FakeSearchView.OnSearchListener {

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
