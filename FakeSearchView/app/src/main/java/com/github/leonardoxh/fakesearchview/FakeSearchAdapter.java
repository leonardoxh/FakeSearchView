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

import android.text.TextUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

/**
 * An custom adapter to filter models more easy
 * @param <T> Any model that extends {@link SearchItem} this make search easy
 *
 * @author Leonardo Rossetto
 */
public abstract class FakeSearchAdapter<T extends SearchItem> extends BaseAdapter
    implements Filterable {

  protected final List<T> items;
  private final List<T> shallowCopy;
  private final Filter filter = new FakeSearchFilter();

  public FakeSearchAdapter(List<T> items) {
    this.items = items;
    this.shallowCopy = new ArrayList<>(items);
  }

  @Override public Filter getFilter() {
    return filter;
  }

  @Override public int getCount() {
    return items.size();
  }

  @Override public T getItem(int position) {
    return items.get(position);
  }

  @Override public long getItemId(int position) {
    return AdapterView.INVALID_ROW_ID;
  }

  /**
   * Custom filter that use {@link SearchItem} to perform a search over the adapter data
   *
   * @author Leonardo Rossetto
   */
  class FakeSearchFilter extends Filter {

    @Override protected FilterResults performFiltering(CharSequence constraint) {
      FilterResults filterResults = new FilterResults();
      if (TextUtils.isEmpty(constraint)) {
        filterResults.values = shallowCopy;
        filterResults.count = shallowCopy.size();
      } else {
        List<T> values = new ArrayList<>();
        for (T item : shallowCopy) {
          if (item.match(constraint)) {
            values.add(item);
          }
        }
        filterResults.count = values.size();
        filterResults.values = values;
      }
      return filterResults;
    }

    //TODO impossible to elimate due FilterResults value
    @SuppressWarnings("unchecked") @Override protected void publishResults(
        CharSequence constraint, FilterResults filterResults) {
      items.clear();
      if (filterResults.count == 0) {
        notifyDataSetInvalidated();
      } else {
        items.addAll((List<T>) filterResults.values);
        notifyDataSetChanged();
      }
    }

  }

}
