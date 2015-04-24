# FakeSearchView
Search made easy!

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FakeSearchView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1723)

![](https://github.com/leonardoxh/FakeSearchView/blob/master/demo.gif)

So I think the native Android SearchView it's a good option when perform a search, but it's not customizable and it's so burocratic!

On my recent projects I use this class many and many times, so it's time to become a library.

It's usage is very very simple, you can use it directly or use a custom adapter like the snipet below, or checkout the sample in this project:

First, create the menu options
```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto">

  <item
    android:id="@+id/fake_search"
    android:title="@string/find"
    android:icon="@drawable/ic_action_search"
    app:showAsAction="ifRoom|collapseActionView"
    app:actionViewClass="com.github.leonardoxh.fakesearchview.FakeSearchView"/>

</menu>
```

After this you will need use this menu in your activity or fragment and set the search listener like this:
```java
public class MainActivity extends Fragment implements FakeSearchView.OnSearchListener {

  private ListView listView;

  /* Another methods */

  @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.menu_devices, menu);
    MenuItem menuItem = menu.findItem(R.id.fake_search);
    FakeSearchView fakeSearchView = (FakeSearchView) MenuItemCompat.getActionView(menuItem);
    fakeSearchView.setOnSearchListener(this);
  }

  @Override public void onSearch(@NotNull FakeSearchView fakeSearchView, @NotNull CharSequence constraint) {
    //The constraint variable here change every time user input data
    ((Filterable)listView.getAdapter()).getFilter().filter(constraint);
    /* Any adapter that implements a Filterable interface, or just extends the built in FakeSearchAdapter
       and implements the searchitem on your model to a custom filter logic */
  }

  @Override public void onSearchHint(@NotNull FakeSearchView fakeSearchView, @NotNull CharSequence constraint) {
    //This is received when the user click in the search button on the keyboard
  }

}
```

Gradle:
===
This library is also available at maven central using gradle:
```groovy
dependencies {
  compile 'com.github.leonardoxh:fake-search-view:0.3.1'
}
```

Licence:
==========
```
Copyright 2015 Leonardo Rossetto

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
