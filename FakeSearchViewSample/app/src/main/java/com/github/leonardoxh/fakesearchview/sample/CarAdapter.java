package com.github.leonardoxh.fakesearchview.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

import com.github.leonardoxh.fakesearchview.FakeSearchAdapter;

import java.util.List;

public class CarAdapter extends FakeSearchAdapter<Car> {

  private final Context context;

  public CarAdapter(Context context, List<Car> items) {
    super(items);
    this.context = context;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.item_car, parent, false);
      viewHolder = new ViewHolder(convertView);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }
    viewHolder.carModel.setText(((Car)getItem(position)).getModel());
    return convertView;
  }

  static class ViewHolder {

    @InjectView(R.id.car_model) TextView carModel;

    ViewHolder(View convertView) {
      ButterKnife.inject(this, convertView);
    }

  }

}
